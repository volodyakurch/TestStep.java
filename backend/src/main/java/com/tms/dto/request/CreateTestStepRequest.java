package com.tms.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateTestStepRequest {
    @NotBlank
    private String action;
    
    private String expectedResult;

    // Getters and Setters
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }
}