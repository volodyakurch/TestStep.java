package com.tms.dto.request;

import com.tms.entity.TestCase;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UpdateTestCaseRequest {
    @NotBlank
    private String name;
    
    private String description;
    private String preconditions;
    
    @NotNull
    private TestCase.Priority priority;
    
    private TestCase.Status status;
    private Long suiteId;
    private List<CreateTestStepRequest> steps;
    private List<String> labels;

    // Getters and Setters
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

    public Long getSuiteId() {
        return suiteId;
    }

    public void setSuiteId(Long suiteId) {
        this.suiteId = suiteId;
    }

    public List<CreateTestStepRequest> getSteps() {
        return steps;
    }

    public void setSteps(List<CreateTestStepRequest> steps) {
        this.steps = steps;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}