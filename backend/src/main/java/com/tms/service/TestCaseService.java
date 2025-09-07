package com.tms.service;

import com.tms.dto.TestCaseDTO;
import com.tms.dto.request.CreateTestCaseRequest;
import com.tms.dto.request.CreateTestStepRequest;
import com.tms.dto.request.UpdateTestCaseRequest;
import com.tms.entity.Project;
import com.tms.entity.TestCase;
import com.tms.entity.TestCaseLabel;
import com.tms.entity.TestStep;
import com.tms.entity.TestSuite;
import com.tms.exception.ResourceNotFoundException;
import com.tms.repository.ProjectRepository;
import com.tms.repository.TestCaseRepository;
import com.tms.repository.TestSuiteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
@Transactional
public class TestCaseService {
    
    private final TestCaseRepository testCaseRepository;
    private final ProjectRepository projectRepository;
    private final TestSuiteRepository testSuiteRepository;
    private final ModelMapper modelMapper;
    
    public TestCaseService(TestCaseRepository testCaseRepository,
                          ProjectRepository projectRepository,
                          TestSuiteRepository testSuiteRepository,
                          ModelMapper modelMapper) {
        this.testCaseRepository = testCaseRepository;
        this.projectRepository = projectRepository;
        this.testSuiteRepository = testSuiteRepository;
        this.modelMapper = modelMapper;
    }
    
    public Page<TestCaseDTO> getTestCases(Long projectId, Long suiteId, String search, int page, int size) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<TestCase> testCases;
        
        if (suiteId != null) {
            TestSuite suite = testSuiteRepository.findByIdAndProjectId(suiteId, projectId)
                    .orElseThrow(() -> new ResourceNotFoundException("Test suite not found"));
            testCases = testCaseRepository.findByProjectAndTestSuite(project, suite, pageable);
        } else if (search != null && !search.trim().isEmpty()) {
            testCases = testCaseRepository.findByProjectAndNameContainingIgnoreCase(project, search, pageable);
        } else {
            testCases = testCaseRepository.findByProject(project, pageable);
        }
        
        return testCases.map(testCase -> modelMapper.map(testCase, TestCaseDTO.class));
    }

    public TestCaseDTO updateTestCase(Long projectId, Long testCaseId, @Valid UpdateTestCaseRequest request) {
        return null;
    }

    public TestCaseDTO getTestCase(Long projectId, Long testCaseId) {
        return null;
    }

    public TestCaseDTO createTestCase(Long projectId, @Valid CreateTestCaseRequest request) {
        return null;
    }

    public void deleteTestCase(Long projectId, Long testCaseId) {

    }

    // Остальные методы сервиса...
}