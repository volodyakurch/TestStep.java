package com.tms.controller;

import com.tms.dto.TestRunDTO;
import com.tms.dto.TestResultDTO;
import com.tms.dto.request.CreateTestRunRequest;
import com.tms.dto.request.CreateTestResultRequest;
import com.tms.service.TestRunService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/projects/{projectId}/test-runs")
@PreAuthorize("hasRole('USER')")
public class TestRunController {

    private final TestRunService testRunService;

    public TestRunController(TestRunService testRunService) {
        this.testRunService = testRunService;
    }

    @GetMapping
    public ResponseEntity<Page<TestRunDTO>> getTestRuns(
            @PathVariable Long projectId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<TestRunDTO> testRuns = testRunService.getTestRuns(projectId, pageable);
        return ResponseEntity.ok(testRuns);
    }

    @GetMapping("/{testRunId}")
    public ResponseEntity<TestRunDTO> getTestRun(
            @PathVariable Long projectId,
            @PathVariable Long testRunId) {

        TestRunDTO testRun = testRunService.getTestRun(projectId, testRunId);
        return ResponseEntity.ok(testRun);
    }

    @PostMapping
    public ResponseEntity<TestRunDTO> createTestRun(
            @PathVariable Long projectId,
            @Valid @RequestBody CreateTestRunRequest request) {

        TestRunDTO testRun = testRunService.createTestRun(projectId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(testRun);
    }

    @PostMapping("/{testRunId}/start")
    public ResponseEntity<TestRunDTO> startTestRun(
            @PathVariable Long projectId,
            @PathVariable Long testRunId) {

        TestRunDTO testRun = testRunService.startTestRun(projectId, testRunId);
        return ResponseEntity.ok(testRun);
    }

    @PostMapping("/{testRunId}/complete")
    public ResponseEntity<TestRunDTO> completeTestRun(
            @PathVariable Long projectId,
            @PathVariable Long testRunId) {

        TestRunDTO testRun = testRunService.completeTestRun(projectId, testRunId);
        return ResponseEntity.ok(testRun);
    }

    @PostMapping("/{testRunId}/results")
    public ResponseEntity<TestResultDTO> addTestResult(
            @PathVariable Long projectId,
            @PathVariable Long testRunId,
            @Valid @RequestBody CreateTestResultRequest request) {

        TestResultDTO testResult = testRunService.addTestResult(projectId, testRunId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(testResult);
    }
}