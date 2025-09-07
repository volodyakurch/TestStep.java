package com.tms.mapper;

import com.tms.dto.TestCaseDTO;
import com.tms.dto.TestRunDTO;
import com.tms.dto.TestResultDTO;
import com.tms.dto.UserDTO;
import com.tms.entity.TestCase;
import com.tms.entity.TestRun;
import com.tms.entity.TestResult;
import com.tms.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        
        // Конфигурация маппинга для TestCase -> TestCaseDTO
        modelMapper.addMappings(new PropertyMap<TestCase, TestCaseDTO>() {
            @Override
            protected void configure() {
                map().setProjectId(source.getProject().getId());
                if (source.getTestSuite() != null) {
                    map().setSuiteId(source.getTestSuite().getId());
                }
            }
        });
        
        // Конфигурация маппинга для TestRun -> TestRunDTO
        modelMapper.addMappings(new PropertyMap<TestRun, TestRunDTO>() {
            @Override
            protected void configure() {
                map().setProjectId(source.getProject().getId());
                if (source.getTestPlan() != null) {
                    map().setTestPlanId(source.getTestPlan().getId());
                }
            }
        });
        
        // Конфигурация маппинга для TestResult -> TestResultDTO
        modelMapper.addMappings(new PropertyMap<TestResult, TestResultDTO>() {
            @Override
            protected void configure() {
                map().setTestCaseId(source.getTestCase().getId());
                map().setTestRunId(source.getTestRun().getId());
                if (source.getAssignedTo() != null) {
                    map().setAssignedToId(source.getAssignedTo().getId());
                }
            }
        });
        
        // Конфигурация маппинга для User -> UserDTO
        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
                // Прямое копирование полей, дополнительная конфигурация не нужна
            }
        });
        
        return modelMapper;
    }
}