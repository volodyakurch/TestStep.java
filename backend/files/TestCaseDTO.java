package com.tms.dto;

import com.tms.entity.TestCase;
import lombok.Data;

import java.util.List;

@Data
public class TestCaseDTO {

    private Long id;
    private String name;
    private String description;
    private String preconditions;
    private TestCase.Priority priority;
    private TestCase.Status status;
    private Long projectId;
    private Long suiteId;
    private List<TestStepDTO> steps;
    private List<String> labels;

    // Getters and Setters
}