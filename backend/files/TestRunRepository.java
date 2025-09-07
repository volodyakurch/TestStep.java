package com.tms.repository;

import com.tms.entity.TestRun;
import com.tms.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRunRepository extends JpaRepository<TestRun, Long> {

    Page<TestRun> findByProject(Project project, Pageable pageable);

    Optional<TestRun> findByIdAndProjectId(Long id, Long projectId);
}