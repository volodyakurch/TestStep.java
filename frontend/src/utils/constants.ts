export const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';

export const PRIORITY_OPTIONS = [
  { value: 'LOW', label: 'Low' },
  { value: 'MEDIUM', label: 'Medium' },
  { value: 'HIGH', label: 'High' },
  { value: 'CRITICAL', label: 'Critical' }
];

export const STATUS_OPTIONS = [
  { value: 'DRAFT', label: 'Draft' },
  { value: 'ACTIVE', label: 'Active' },
  { value: 'DEPRECATED', label: 'Deprecated' }
];

export const TEST_RUN_STATUS_OPTIONS = [
  { value: 'NOT_STARTED', label: 'Not Started' },
  { value: 'IN_PROGRESS', label: 'In Progress' },
  { value: 'COMPLETED', label: 'Completed' },
  { value: 'STOPPED', label: 'Stopped' }
];

export const EXECUTION_STATUS_OPTIONS = [
  { value: 'PASSED', label: 'Passed' },
  { value: 'FAILED', label: 'Failed' },
  { value: 'BLOCKED', label: 'Blocked' },
  { value: 'SKIPPED', label: 'Skipped' },
  { value: 'RETEST', label: 'Retest' }
];