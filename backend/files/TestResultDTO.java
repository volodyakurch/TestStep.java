package com.tms.dto;

import com.tms.entity.TestResult;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TestResultDTO {

    private Long id;
    private TestResult.ExecutionStatus status;
    private LocalDateTime executionTime;
    private Long durationMs;
    private String comment;
    private String failureReason;
    private String allureReportUrl;
    private Long testCaseId;
    private Long testRunId;
    private Long assignedToId;

    // Getters and Setters
}