import React, { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import {
  Container,
  Typography,
  Button,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  TablePagination,
  Chip,
  IconButton,
  Box,
} from '@mui/material';
import { PlayArrow, Visibility, Edit } from '@mui/icons-material';
import { TestRun, TestRunStatus } from '../../types';
import { testRunService } from '../../services/testRunService';

const TestRuns: React.FC = () => {
  const { projectId } = useParams<{ projectId: string }>();
  const [testRuns, setTestRuns] = useState<TestRun[]>([]);
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);
  const [totalElements, setTotalElements] = useState(0);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    fetchTestRuns();
  }, [page, rowsPerPage]);

  const fetchTestRuns = async () => {
    if (!projectId) return;
    
    setLoading(true);
    try {
      // Mock data - replace with actual API call
      const mockTestRuns: TestRun[] = [
        { 
          id: 1, 
          name: 'Regression Test - v1.2.0', 
          description: 'Full regression test for release 1.2.0', 
          status: TestRunStatus.COMPLETED, 
          startTime: '2023-01-15T10:00:00',
          endTime: '2023-01-15T18:30:00',
          projectId: parseInt(projectId),
          testResults: []
        },
        { 
          id: 2, 
          name: 'Smoke Test - Production', 
          description: 'Quick smoke test after deployment', 
          status: TestRunStatus.IN_PROGRESS, 
          startTime: '2023-01-16T09:00:00',
          endTime: '',
          projectId: parseInt(projectId),
          testResults: []
        },
      ];
      
      setTestRuns(mockTestRuns);
      setTotalElements(mockTestRuns.length);
    } catch (error) {
      console.error('Failed to fetch test runs:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleChangePage = (event: unknown, newPage: number) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event: React.ChangeEvent<HTMLInputElement>) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  const getStatusColor = (status: TestRunStatus) => {
    switch (status) {
      case TestRunStatus.NOT_STARTED: return 'default';
      case TestRunStatus.IN_PROGRESS: return 'primary';
      case TestRunStatus.COMPLETED: return 'success';
      case TestRunStatus.STOPPED: return 'error';
      default: return 'default';
    }
  };

  const startTestRun = async (testRunId: number) => {
    if (!projectId) return;
    
    try {
      await testRunService.startTestRun(parseInt(projectId), testRunId);
      fetchTestRuns(); // Refresh the list
    } catch (error) {
      console.error('Failed to start test run:', error);
    }
  };

  return (
    <Container maxWidth="xl" sx={{ mt: 4, mb: 4 }}>
      <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', mb: 3 }}>
        <Typography variant="h4" component="h1">
          Test Runs
        </Typography>
        <Button
          variant="contained"
          color="primary"
          component={Link}
          to={`/projects/${projectId}/test-runs/new`}
        >
          Create Test Run
        </Button>
      </Box>

      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Name</TableCell>
              <TableCell>Status</TableCell>
              <TableCell>Start Time</TableCell>
              <TableCell>End Time</TableCell>
              <TableCell>Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {testRuns.map((testRun) => (
              <TableRow key={testRun.id}>
                <TableCell>{testRun.id}</TableCell>
                <TableCell>
                  <Typography variant="body2" noWrap sx={{ maxWidth: 200 }}>
                    {testRun.name}
                  </Typography>
                </TableCell>
                <TableCell>
                  <Chip
                    label={testRun.status}
                    size="small"
                    color={getStatusColor(testRun.status)}
                  />
                </TableCell>
                <TableCell>
                  {testRun.startTime ? new Date(testRun.startTime).toLocaleString() : '-'}
                </TableCell>
                <TableCell>
                  {testRun.endTime ? new Date(testRun.endTime).toLocaleString() : '-'}
                </TableCell>
                <TableCell>
                  <IconButton
                    size="small"
                    component={Link}
                    to={`/projects/${projectId}/test-runs/${testRun.id}`}
                  >
                    <Visibility />
                  </IconButton>
                  {testRun.status === TestRunStatus.NOT_STARTED && (
                    <IconButton
                      size="small"
                      onClick={() => startTestRun(testRun.id)}
                    >
                      <PlayArrow />
                    </IconButton>
                  )}
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>

      <TablePagination
        rowsPerPageOptions={[5, 10, 25]}
        component="div"
        count={totalElements}
        rowsPerPage={rowsPerPage}
        page={page}
        onPageChange={handleChangePage}
        onRowsPerPageChange={handleChangeRowsPerPage}
      />
    </Container>
  );
};

export default TestRuns;