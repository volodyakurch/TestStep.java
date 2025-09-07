package com.tms.service;

import com.tms.dto.TestRunDTO;
import com.tms.dto.request.CreateTestRunRequest;
import com.tms.dto.request.CreateTestResultRequest;
import com.tms.dto.TestResultDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TestRunService {

    Page<TestRunDTO> getTestRuns(Long projectId, Pageable pageable);

    TestRunDTO getTestRun(Long projectId, Long testRunId);

    TestRunDTO createTestRun(Long projectId, CreateTestRunRequest request);

    TestRunDTO startTestRun(Long projectId, Long testRunId);

    TestRunDTO completeTestRun(Long projectId, Long testRunId);

    TestResultDTO addTestResult(Long projectId, Long testRunId, CreateTestResultRequest request);
}