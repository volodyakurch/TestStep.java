package com.tms.repository;

import com.tms.entity.TestPlan;
import com.tms.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestPlanRepository extends JpaRepository<TestPlan, Long> {

    List<TestPlan> findByProject(Project project);

    Optional<TestPlan> findByIdAndProjectId(Long id, Long projectId);

    boolean existsByNameAndProject(String name, Project project);
}