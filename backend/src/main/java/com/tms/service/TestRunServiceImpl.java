package com.tms.service;

import com.tms.dto.TestRunDTO;
import com.tms.dto.TestResultDTO;
import com.tms.dto.request.CreateTestRunRequest;
import com.tms.dto.request.CreateTestResultRequest;
import com.tms.entity.Project;
import com.tms.entity.TestRun;
import com.tms.entity.TestResult;
import com.tms.entity.TestCase;
import com.tms.entity.User;
import com.tms.exception.ResourceNotFoundException;
import com.tms.repository.ProjectRepository;
import com.tms.repository.TestRunRepository;
import com.tms.repository.TestCaseRepository;
import com.tms.repository.TestResultRepository;
import com.tms.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TestRunServiceImpl implements TestRunService {

    private final TestRunRepository testRunRepository;
    private final ProjectRepository projectRepository;
    private final TestCaseRepository testCaseRepository;
    private final TestResultRepository testResultRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TestRunServiceImpl(TestRunRepository testRunRepository,
                              ProjectRepository projectRepository,
                              TestCaseRepository testCaseRepository,
                              TestResultRepository testResultRepository,
                              UserRepository userRepository,
                              ModelMapper modelMapper) {
        this.testRunRepository = testRunRepository;
        this.projectRepository = projectRepository;
        this.testCaseRepository = testCaseRepository;
        this.testResultRepository = testResultRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<TestRunDTO> getTestRuns(Long projectId, Pageable pageable) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        Page<TestRun> testRuns = testRunRepository.findByProject(project, pageable);
        return testRuns.map(testRun -> modelMapper.map(testRun, TestRunDTO.class));
    }

    @Override
    public TestRunDTO getTestRun(Long projectId, Long testRunId) {
        TestRun testRun = testRunRepository.findByIdAndProjectId(testRunId, projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Test run not found"));

        return modelMapper.map(testRun, TestRunDTO.class);
    }

    @Override
    public TestRunDTO createTestRun(Long projectId, CreateTestRunRequest request) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        TestRun testRun = new TestRun();
        testRun.setName(request.getName());
        testRun.setDescription(request.getDescription());
        testRun.setStatus(TestRun.TestRunStatus.NOT_STARTED);
        testRun.setProject(project);

        testRun = testRunRepository.save(testRun);
        return modelMapper.map(testRun, TestRunDTO.class);
    }

    @Override
    public TestRunDTO startTestRun(Long projectId, Long testRunId) {
        TestRun testRun = testRunRepository.findByIdAndProjectId(testRunId, projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Test run not found"));

        testRun.setStatus(TestRun.TestRunStatus.IN_PROGRESS);
        testRun.setStartTime(LocalDateTime.now());

        testRun = testRunRepository.save(testRun);
        return modelMapper.map(testRun, TestRunDTO.class);
    }

    @Override
    public TestRunDTO completeTestRun(Long projectId, Long testRunId) {
        TestRun testRun = testRunRepository.findByIdAndProjectId(testRunId, projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Test run not found"));

        testRun.setStatus(TestRun.TestRunStatus.COMPLETED);
        testRun.setEndTime(LocalDateTime.now());

        testRun = testRunRepository.save(testRun);
        return modelMapper.map(testRun, TestRunDTO.class);
    }

    @Override
    public TestResultDTO addTestResult(Long projectId, Long testRunId, CreateTestResultRequest request) {
        TestRun testRun = testRunRepository.findByIdAndProjectId(testRunId, projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Test run not found"));

        TestCase testCase = testCaseRepository.findByIdAndProjectId(request.getTestCaseId(), projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Test case not found"));

        User assignedTo = null;
        if (request.getAssignedToId() != null) {
            assignedTo = userRepository.findById(request.getAssignedToId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        }

        TestResult testResult = new TestResult();
        testResult.setStatus(request.getStatus());
        testResult.setExecutionTime(LocalDateTime.now());
        testResult.setDurationMs(request.getDurationMs());
        testResult.setComment(request.getComment());
        testResult.setFailureReason(request.getFailureReason());
        testResult.setAllureReportUrl(request.getAllureReportUrl());
        testResult.setTestCase(testCase);
        testResult.setTestRun(testRun);
        testResult.setAssignedTo(assignedTo);

        testResult = testResultRepository.save(testResult);
        return modelMapper.map(testResult, TestResultDTO.class);
    }
}