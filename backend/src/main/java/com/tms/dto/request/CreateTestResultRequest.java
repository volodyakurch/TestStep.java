package com.tms.dto.request;

import com.tms.entity.TestResult;
import javax.validation.constraints.NotNull;

public class CreateTestResultRequest {
    @NotNull
    private TestResult.ExecutionStatus status;

    private Long durationMs;
    private String comment;
    private String failureReason;
    private String allureReportUrl;

    @NotNull
    private Long testCaseId;

    private Long assignedToId;

    // Getters and Setters
    public TestResult.ExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(TestResult.ExecutionStatus status) {
        this.status = status;
    }

    public Long getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Long durationMs) {
        this.durationMs = durationMs;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getAllureReportUrl() {
        return allureReportUrl;
    }

    public void setAllureReportUrl(String allureReportUrl) {
        this.allureReportUrl = allureReportUrl;
    }

    public Long getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(Long testCaseId) {
        this.testCaseId = testCaseId;
    }

    public Long getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Long assignedToId) {
        this.assignedToId = assignedToId;
    }
}