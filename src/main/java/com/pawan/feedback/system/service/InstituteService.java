package com.pawan.feedback.system.service;

import com.pawan.feedback.system.dto.request.CreateInstituteRequestDto;
import com.pawan.feedback.system.dto.response.InstituteResponseDto;

import java.util.List;

public interface InstituteService {

    InstituteResponseDto createInstitute(
            CreateInstituteRequestDto request
    );

    List<InstituteResponseDto> getAllInstitutes();
}