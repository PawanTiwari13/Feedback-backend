package com.pawan.feedback.system.authservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.feedback.system.dto.request.CreateUserRequestDto;
import com.pawan.feedback.system.dto.request.LoginRequestDto;
import com.pawan.feedback.system.dto.response.LoginResponseDto;
import com.pawan.feedback.system.dto.response.UserResponseDto;
import com.pawan.feedback.system.entity.Role;
import com.pawan.feedback.system.entity.User;
import com.pawan.feedback.system.entity.UserRole;
import com.pawan.feedback.system.repository.RoleRepository;
import com.pawan.feedback.system.repository.UserRepository;
import com.pawan.feedback.system.repository.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private JwtUtil jwtUtil;
		
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public LoginResponseDto login(LoginRequestDto request) {

		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("Invalid email"));

		boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());

		if (!matches) {
			throw new RuntimeException("Invalid password");
		}

		List<String> roles = user.getRoles()

		        .stream()

		        .map(userRole ->
		                userRole.getRole().getName()
		        )

		        .toList();
		// REAL JWT TOKEN
		String token = jwtUtil.generateToken(user.getEmail(), roles);

		return new LoginResponseDto(token, roles);
	}

	@Override
	public UserResponseDto createUser(
	        CreateUserRequestDto request
	) {

	    if (userRepository.existsByEmail(
	            request.getEmail()
	    )) {

	        throw new RuntimeException(
	                "Email already exists"
	        );
	    }

	    User user = new User();

	    user.setEmail(request.getEmail());

	    user.setPassword(
	            passwordEncoder.encode(
	                    request.getPassword()
	            )
	    );

	    user.setActive(true);

	    User savedUser =
	            userRepository.save(user);

	    // MULTIPLE ROLE ASSIGNMENT
	    for(String roleName : request.getRoles()) {

	        Role role = roleRepository

	                .findByName(
	                        roleName.toUpperCase()
	                )

	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Role not found"
	                        )
	                );

	        UserRole userRole = new UserRole();

	        userRole.setUser(savedUser);

	        userRole.setRole(role);

	        userRoleRepository.save(userRole);
	    }

	    return new UserResponseDto(

	            savedUser.getId(),

	            savedUser.getEmail(),

	            request.getRoles(),

	            savedUser.isActive()
	    );
	}
}