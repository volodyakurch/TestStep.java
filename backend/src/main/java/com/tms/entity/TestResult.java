package com.tms.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_results")
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExecutionStatus status;

    @Column(name = "execution_time")
    private LocalDateTime executionTime;

    @Column(name = "duration_ms")
    private Long durationMs;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(name = "failure_reason", columnDefinition = "TEXT")
    private String failureReason;

    @Column(name = "allure_report_url")
    private String allureReportUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_run_id")
    private TestRun testRun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    // Конструкторы
    public TestResult() {
    }

    public TestResult(ExecutionStatus status, LocalDateTime executionTime, Long durationMs,
                      String comment, String failureReason, String allureReportUrl,
                      TestCase testCase, TestRun testRun, User assignedTo) {
        this.status = status;
        this.executionTime = executionTime;
        this.durationMs = durationMs;
        this.comment = comment;
        this.failureReason = failureReason;
        this.allureReportUrl = allureReportUrl;
        this.testCase = testCase;
        this.testRun = testRun;
        this.assignedTo = assignedTo;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(ExecutionStatus status) {
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

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    public TestRun getTestRun() {
        return testRun;
    }

    public void setTestRun(TestRun testRun) {
        this.testRun = testRun;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public enum ExecutionStatus {
        PASSED, FAILED, BLOCKED, SKIPPED, RETEST
    }
}