package com.tms.dto;

import lombok.Data;

@Data
public class TestStepDTO {

    private Long id;
    private String action;
    private String expectedResult;
    private Long testCaseId;

    // Getters and Setters
}