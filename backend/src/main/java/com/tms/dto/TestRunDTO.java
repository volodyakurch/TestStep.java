package com.tms.dto;

import com.tms.entity.TestRun;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TestRunDTO {

    private Long id;
    private String name;
    private String description;
    private TestRun.TestRunStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long projectId;
    private Long testPlanId;
    private List<TestResultDTO> testResults;

    public void setTestPlanId(Long id) {
    }

    public void clone (Long id){

    }

    // Getters and Setters
}