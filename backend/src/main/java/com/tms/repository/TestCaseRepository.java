package com.tms.repository;

import com.tms.entity.TestCase;
import com.tms.entity.Project;
import com.tms.entity.TestSuite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    Page<TestCase> findByProject(Project project, Pageable pageable);

    Page<TestCase> findByProjectAndNameContainingIgnoreCase(Project project, String name, Pageable pageable);

    Optional<TestCase> findByIdAndProjectId(Long id, Long projectId);

    Page<TestCase> findByProjectAndTestSuite(Project project, TestSuite suite, Pageable pageable);
}