package com.tms.controller;

import com.tms.dto.TestCaseDTO;
import com.tms.dto.request.CreateTestCaseRequest;
import com.tms.dto.request.UpdateTestCaseRequest;
import com.tms.service.TestCaseService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/projects/{projectId}/test-cases")
@PreAuthorize("hasRole('USER')")
public class TestCaseController {
    
    private final TestCaseService testCaseService;
    
    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }
    
    @GetMapping
    public ResponseEntity<Page<TestCaseDTO>> getTestCases(
            @PathVariable Long projectId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(required = false) Long suiteId,
            @RequestParam(required = false) String search) {
        
        Page<TestCaseDTO> testCases = testCaseService.getTestCases(projectId, suiteId, search, page, size);
        return ResponseEntity.ok(testCases);
    }
    
    @GetMapping("/{testCaseId}")
    public ResponseEntity<TestCaseDTO> getTestCase(
            @PathVariable Long projectId,
            @PathVariable Long testCaseId) {
        
        TestCaseDTO testCase = testCaseService.getTestCase(projectId, testCaseId);
        return ResponseEntity.ok(testCase);
    }
    
    @PostMapping
    public ResponseEntity<TestCaseDTO> createTestCase(
            @PathVariable Long projectId,
            @Valid @RequestBody CreateTestCaseRequest request) {
        
        TestCaseDTO testCase = testCaseService.createTestCase(projectId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(testCase);
    }
    
    @PutMapping("/{testCaseId}")
    public ResponseEntity<TestCaseDTO> updateTestCase(
            @PathVariable Long projectId,
            @PathVariable Long testCaseId,
            @Valid @RequestBody UpdateTestCaseRequest request) {
        
        TestCaseDTO testCase = testCaseService.updateTestCase(projectId, testCaseId, request);
        return ResponseEntity.ok(testCase);
    }
    
    @DeleteMapping("/{testCaseId}")
    public ResponseEntity<Void> deleteTestCase(
            @PathVariable Long projectId,
            @PathVariable Long testCaseId) {
        
        testCaseService.deleteTestCase(projectId, testCaseId);
        return ResponseEntity.noContent().build();
    }
}