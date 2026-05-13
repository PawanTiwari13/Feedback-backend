package com.pawan.feedback.system.controller;

import com.pawan.feedback.system.dto.request.CreateInstituteRequestDto;
import com.pawan.feedback.system.dto.response.InstituteResponseDto;

import com.pawan.feedback.system.service.InstituteService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/institutes")
public class AdminInstituteController {

    @Autowired
    private InstituteService instituteService;

    // CREATE INSTITUTE
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<InstituteResponseDto>
    createInstitute(
            @RequestBody
            CreateInstituteRequestDto request
    ) {

        return ResponseEntity

                .status(HttpStatus.CREATED)

                .body(
                        instituteService
                                .createInstitute(request)
                );
    }

    // GET ALL INSTITUTES
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<InstituteResponseDto>>
    getAllInstitutes() {

        return ResponseEntity.ok(
                instituteService.getAllInstitutes()
        );
    }
}