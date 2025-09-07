import apiClient from './apiClient';
import { TestCase, Page } from '../types';

export const testCaseService = {
  getTestCases: async (projectId: number, page: number = 0, size: number = 20, suiteId?: number, search?: string): Promise<Page<TestCase>> => {
    const params: any = { page, size };
    if (suiteId) params.suiteId = suiteId;
    if (search) params.search = search;
    
    const response = await apiClient.get(`/v1/projects/${projectId}/test-cases`, { params });
    return response.data;
  },

  getTestCase: async (projectId: number, testCaseId: number): Promise<TestCase> => {
    const response = await apiClient.get(`/v1/projects/${projectId}/test-cases/${testCaseId}`);
    return response.data;
  },

  createTestCase: async (projectId: number, testCase: Partial<TestCase>): Promise<TestCase> => {
    const response = await apiClient.post(`/v1/projects/${projectId}/test-cases`, testCase);
    return response.data;
  },

  updateTestCase: async (projectId: number, testCaseId: number, testCase: Partial<TestCase>): Promise<TestCase> => {
    const response = await apiClient.put(`/v1/projects/${projectId}/test-cases/${testCaseId}`, testCase);
    return response.data;
  },

  deleteTestCase: async (projectId: number, testCaseId: number): Promise<void> => {
    await apiClient.delete(`/v1/projects/${projectId}/test-cases/${testCaseId}`);
  },
};