export interface User {
  id: number;
  username: string;
  email: string;
  firstName: string;
  lastName: string;
}

export interface Project {
  id: number;
  name: string;
  description: string;
  isPublic: boolean;
}

export interface TestCase {
  id: number;
  name: string;
  description: string;
  preconditions: string;
  priority: Priority;
  status: Status;
  projectId: number;
  testSuite?: TestSuite;
  steps: TestStep[];
  labels: string[];
}

export interface TestStep {
  id: number;
  action: string;
  expectedResult: string;
  testCaseId: number;
}

export interface TestSuite {
  id: number;
  name: string;
  description: string;
  projectId: number;
}

export interface TestRun {
  id: number;
  name: string;
  description: string;
  status: TestRunStatus;
  startTime: string;
  endTime: string;
  projectId: number;
  testPlanId?: number;
  testResults: TestResult[];
}

export interface TestResult {
  id: number;
  status: ExecutionStatus;
  executionTime: string;
  durationMs: number;
  comment: string;
  failureReason: string;
  allureReportUrl: string;
  testCaseId: number;
  testRunId: number;
  assignedTo?: User;
}

export interface LoginCredentials {
  username: string;
  password: string;
}

export interface RegisterData {
  username: string;
  email: string;
  password: string;
  firstName: string;
  lastName: string;
}

export interface Page<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
}

export enum Priority {
  LOW = 'LOW',
  MEDIUM = 'MEDIUM',
  HIGH = 'HIGH',
  CRITICAL = 'CRITICAL'
}

export enum Status {
  DRAFT = 'DRAFT',
  ACTIVE = 'ACTIVE',
  DEPRECATED = 'DEPRECATED'
}

export enum TestRunStatus {
  NOT_STARTED = 'NOT_STARTED',
  IN_PROGRESS = 'IN_PROGRESS',
  COMPLETED = 'COMPLETED',
  STOPPED = 'STOPPED'
}

export enum ExecutionStatus {
  PASSED = 'PASSED',
  FAILED = 'FAILED',
  BLOCKED = 'BLOCKED',
  SKIPPED = 'SKIPPED',
  RETEST = 'RETEST'
}