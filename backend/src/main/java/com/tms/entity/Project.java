package com.tms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    private String description;
    
    @Column(name = "is_public")
    private boolean isPublic = false;
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<TestSuite> testSuites = new ArrayList<>();
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<TestCase> testCases = new ArrayList<>();
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<TestPlan> testPlans = new ArrayList<>();
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<TestRun> testRuns = new ArrayList<>();

    public Long getId() {
        return null;
    }

    // Getters and setters
}