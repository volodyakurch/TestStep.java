package com.tms.dto;

import com.tms.entity.TestCase;
import lombok.Data;

import java.util.List;

@Data
public class TestCaseDTO {
    private Long id;
    private String name;
    private String description;
    private String preconditions;
    private TestCase.Priority priority;
    private TestCase.Status status;
    private Long projectId;
    private Long suiteId;
    private List<TestStepDTO> steps;
    private List<String> labels;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(String preconditions) {
        this.preconditions = preconditions;
    }

    public TestCase.Priority getPriority() {
        return priority;
    }

    public void setPriority(TestCase.Priority priority) {
        this.priority = priority;
    }

    public TestCase.Status getStatus() {
        return status;
    }

    public void setStatus(TestCase.Status status) {
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getSuiteId() {
        return suiteId;
    }

    public void setSuiteId(Long suiteId) {
        this.suiteId = suiteId;
    }

    public List<TestStepDTO> getSteps() {
        return steps;
    }

    public void setSteps(List<TestStepDTO> steps) {
        this.steps = steps;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}