package com.tms.repository;

import com.tms.entity.TestSuite;
import com.tms.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestSuiteRepository extends JpaRepository<TestSuite, Long> {
    List<TestSuite> findByProject(Project project);
    Optional<TestSuite> findByIdAndProjectId(Long id, Long projectId);
}