package com.pawan.feedback.system.service;


import com.pawan.feedback.system.dto.request.CreateInstituteRequestDto;
import com.pawan.feedback.system.dto.response.InstituteResponseDto;

import com.pawan.feedback.system.entity.Institute;

import com.pawan.feedback.system.repository.InstituteRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteServiceImpl
        implements InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;

    @Override
    public InstituteResponseDto createInstitute(
            CreateInstituteRequestDto request
    ) {

        if(instituteRepository.existsByInstituteCode(
                request.getInstituteCode()
        )) {

            throw new RuntimeException(
                    "Institute code already exists"
            );
        }

        Institute institute = new Institute();

        institute.setInstituteCode(
                request.getInstituteCode()
        );

        institute.setInstituteName(
                request.getInstituteName()
        );

        institute.setCity(
                request.getCity()
        );

        Institute savedInstitute =
                instituteRepository.save(institute);

        return new InstituteResponseDto(

                savedInstitute.getId(),

                savedInstitute.getInstituteCode(),

                savedInstitute.getInstituteName(),

                savedInstitute.getCity(),

                savedInstitute.isActive()
        );
    }

    @Override
    public List<InstituteResponseDto>
    getAllInstitutes() {

        return instituteRepository.findAll()

                .stream()

                .map(institute ->

                        new InstituteResponseDto(

                                institute.getId(),

                                institute.getInstituteCode(),

                                institute.getInstituteName(),

                                institute.getCity(),

                                institute.isActive()
                        )
                )

                .toList();
    }
}