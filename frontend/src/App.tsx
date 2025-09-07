import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import { AuthProvider } from './contexts/AuthContext';
import { NotificationProvider } from './contexts/NotificationContext';
import Layout from './components/layout/Layout';
import Login from './components/auth/Login';
import Dashboard from './components/dashboard/Dashboard';
import Projects from './components/projects/Projects';
import ProjectDetails from './components/projects/ProjectDetails';
import TestCases from './components/test-cases/TestCases';
import TestCaseDetail from './components/test-cases/TestCaseDetail';
import TestRuns from './components/test-runs/TestRuns';
import TestRunDetail from './components/test-runs/TestRunDetail';
import ProtectedRoute from './components/auth/ProtectedRoute';

const theme = createTheme({
  palette: {
    primary: {
      main: '#1976d2',
    },
    secondary: {
      main: '#dc004e',
    },
  },
});

function App() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <NotificationProvider>
        <AuthProvider>
          <Router>
            <Layout>
              <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/" element={<ProtectedRoute><Dashboard /></ProtectedRoute>} />
                <Route path="/projects" element={<ProtectedRoute><Projects /></ProtectedRoute>} />
                <Route path="/projects/:projectId" element={<ProtectedRoute><ProjectDetails /></ProtectedRoute>} />
                <Route path="/projects/:projectId/test-cases" element={<ProtectedRoute><TestCases /></ProtectedRoute>} />
                <Route path="/projects/:projectId/test-cases/:testCaseId" element={<ProtectedRoute><TestCaseDetail /></ProtectedRoute>} />
                <Route path="/projects/:projectId/test-runs" element={<ProtectedRoute><TestRuns /></ProtectedRoute>} />
                <Route path="/projects/:projectId/test-runs/:testRunId" element={<ProtectedRoute><TestRunDetail /></ProtectedRoute>} />
              </Routes>
            </Layout>
          </Router>
        </AuthProvider>
      </NotificationProvider>
    </ThemeProvider>
  );
}

export default App;