import apiClient from './apiClient';
import { TestRun, TestResult, Page } from '../types';

export const testRunService = {
  getTestRuns: async (projectId: number, page: number = 0, size: number = 20): Promise<Page<TestRun>> => {
    const response = await apiClient.get(`/v1/projects/${projectId}/test-runs`, {
      params: { page, size }
    });
    return response.data;
  },

  getTestRun: async (projectId: number, testRunId: number): Promise<TestRun> => {
    const response = await apiClient.get(`/v1/projects/${projectId}/test-runs/${testRunId}`);
    return response.data;
  },

  createTestRun: async (projectId: number, testRun: Partial<TestRun>): Promise<TestRun> => {
    const response = await apiClient.post(`/v1/projects/${projectId}/test-runs`, testRun);
    return response.data;
  },

  startTestRun: async (projectId: number, testRunId: number): Promise<TestRun> => {
    const response = await apiClient.post(`/v1/projects/${projectId}/test-runs/${testRunId}/start`);
    return response.data;
  },

  completeTestRun: async (projectId: number, testRunId: number): Promise<TestRun> => {
    const response = await apiClient.post(`/v1/projects/${projectId}/test-runs/${testRunId}/complete`);
    return response.data;
  },

  addTestResult: async (projectId: number, testRunId: number, testResult: Partial<TestResult>): Promise<TestResult> => {
    const response = await apiClient.post(`/v1/projects/${projectId}/test-runs/${testRunId}/results`, testResult);
    return response.data;
  },
};