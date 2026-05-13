package com.pawan.feedback.system.authservice;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        final String authHeader =
                request.getHeader("Authorization");

        System.out.println("AUTH HEADER : " + authHeader);

        String jwt = null;

        String email = null;

        // CHECK HEADER
        if (authHeader != null
                && authHeader.startsWith("Bearer ")) {

            jwt = authHeader.substring(7);

            System.out.println("JWT : " + jwt);

            try {

                email = jwtUtil.extractEmail(jwt);

                System.out.println("EMAIL : " + email);

            } catch (Exception e) {

                System.out.println("JWT ERROR : "
                        + e.getMessage());

                e.printStackTrace();
            }
        }

        // AUTHENTICATE USER
        if (email != null
                && SecurityContextHolder.getContext()
                .getAuthentication() == null) {

            UserDetails userDetails =
                    userDetailsService
                            .loadUserByUsername(email);

            boolean isValid =
                    jwtUtil.validateToken(jwt, userDetails);

            System.out.println(
                    "TOKEN VALID : " + isValid
            );

            if (isValid) {

                UsernamePasswordAuthenticationToken authToken =

                        new UsernamePasswordAuthenticationToken(

                                userDetails,

                                null,

                                userDetails.getAuthorities()
                        );

                authToken.setDetails(

                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authToken);

                System.out.println(
                        "USER AUTHENTICATED SUCCESSFULLY"
                );
            }
        }

        filterChain.doFilter(request, response);
    }
}