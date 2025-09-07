package com.tms.dto;

import com.tms.entity.TestResult;
import java.time.LocalDateTime;

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
    private String assignedToName;

    // Конструкторы
    public TestResultDTO() {
    }

    public TestResultDTO(Long id, TestResult.ExecutionStatus status, LocalDateTime executionTime,
                         Long durationMs, String comment, String failureReason, String allureReportUrl,
                         Long testCaseId, Long testRunId, Long assignedToId, String assignedToName) {
        this.id = id;
        this.status = status;
        this.executionTime = executionTime;
        this.durationMs = durationMs;
        this.comment = comment;
        this.failureReason = failureReason;
        this.allureReportUrl = allureReportUrl;
        this.testCaseId = testCaseId;
        this.testRunId = testRunId;
        this.assignedToId = assignedToId;
        this.assignedToName = assignedToName;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestResult.ExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(TestResult.ExecutionStatus status) {
        this.status = status;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalDateTime executionTime) {
        this.executionTime = executionTime;
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

    public Long getTestRunId() {
        return testRunId;
    }

    public void setTestRunId(Long testRunId) {
        this.testRunId = testRunId;
    }

    public Long getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Long assignedToId) {
        this.assignedToId = assignedToId;
    }

    public String getAssignedToName() {
        return assignedToName;
    }

    public void setAssignedToName(String assignedToName) {
        this.assignedToName = assignedToName;
    }

    public String toString(Long id) {
        return "TestResultDTO{" +
                "id=" + this.id +
                ", status=" + status +
                ", executionTime=" + executionTime +
                ", durationMs=" + durationMs +
                ", comment='" + comment + '\'' +
                ", failureReason='" + failureReason + '\'' +
                ", allureReportUrl='" + allureReportUrl + '\'' +
                ", testCaseId=" + testCaseId +
                ", testRunId=" + testRunId +
                ", assignedToId=" + assignedToId +
                ", assignedToName='" + assignedToName + '\'' +
                '}';
    }
}