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
  TextField,
  MenuItem,
} from '@mui/material';
import { Edit, Visibility, PlayArrow } from '@mui/icons-material';
import { TestCase, Priority, Status } from '../../types';
import { testCaseService } from '../../services/testCaseService';

const TestCases: React.FC = () => {
  const { projectId } = useParams<{ projectId: string }>();
  const [testCases, setTestCases] = useState<TestCase[]>([]);
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);
  const [totalElements, setTotalElements] = useState(0);
  const [loading, setLoading] = useState(false);
  const [searchTerm, setSearchTerm] = useState('');
  const [statusFilter, setStatusFilter] = useState<Status | 'all'>('all');
  const [priorityFilter, setPriorityFilter] = useState<Priority | 'all'>('all');

  useEffect(() => {
    fetchTestCases();
  }, [page, rowsPerPage, searchTerm, statusFilter, priorityFilter]);

  const fetchTestCases = async () => {
    if (!projectId) return;
    
    setLoading(true);
    try {
      // Mock data - replace with actual API call
      const mockTestCases: TestCase[] = [
        { 
          id: 1, 
          name: 'Login functionality', 
          description: 'Test user login with valid and invalid credentials', 
          preconditions: 'User must be registered',
          priority: Priority.HIGH, 
          status: Status.ACTIVE, 
          projectId: parseInt(projectId),
          steps: [],
          labels: ['authentication', 'login']
        },
        { 
          id: 2, 
          name: 'User registration', 
          description: 'Test new user registration process', 
          preconditions: 'No preconditions needed',
          priority: Priority.MEDIUM, 
          status: Status.ACTIVE, 
          projectId: parseInt(projectId),
          steps: [],
          labels: ['authentication', 'registration']
        },
      ];
      
      // Apply filters
      let filteredCases = mockTestCases;
      
      if (statusFilter !== 'all') {
        filteredCases = filteredCases.filter(tc => tc.status === statusFilter);
      }
      
      if (priorityFilter !== 'all') {
        filteredCases = filteredCases.filter(tc => tc.priority === priorityFilter);
      }
      
      if (searchTerm) {
        filteredCases = filteredCases.filter(tc => 
          tc.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
          tc.description.toLowerCase().includes(searchTerm.toLowerCase())
        );
      }
      
      setTestCases(filteredCases);
      setTotalElements(filteredCases.length);
    } catch (error) {
      console.error('Failed to fetch test cases:', error);
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

  const getPriorityColor = (priority: Priority) => {
    switch (priority) {
      case Priority.LOW: return 'default';
      case Priority.MEDIUM: return 'primary';
      case Priority.HIGH: return 'secondary';
      case Priority.CRITICAL: return 'error';
      default: return 'default';
    }
  };

  const getStatusColor = (status: Status) => {
    switch (status) {
      case Status.ACTIVE: return 'success';
      case Status.DRAFT: return 'default';
      case Status.DEPRECATED: return 'error';
      default: return 'default';
    }
  };

  return (
    <Container maxWidth="xl" sx={{ mt: 4, mb: 4 }}>
      <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', mb: 3 }}>
        <Typography variant="h4" component="h1">
          Test Cases
        </Typography>
        <Button
          variant="contained"
          color="primary"
          component={Link}
          to={`/projects/${projectId}/test-cases/new`}
        >
          Create Test Case
        </Button>
      </Box>

      <Paper sx={{ p: 2, mb: 2 }}>
        <Box sx={{ display: 'flex', gap: 2, flexWrap: 'wrap' }}>
          <TextField
            label="Search"
            variant="outlined"
            size="small"
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            sx={{ minWidth: 200 }}
          />
          <TextField
            select
            label="Status"
            variant="outlined"
            size="small"
            value={statusFilter}
            onChange={(e) => setStatusFilter(e.target.value as Status | 'all')}
            sx={{ minWidth: 120 }}
          >
            <MenuItem value="all">All</MenuItem>
            <MenuItem value={Status.DRAFT}>Draft</MenuItem>
            <MenuItem value={Status.ACTIVE}>Active</MenuItem>
            <MenuItem value={Status.DEPRECATED}>Deprecated</MenuItem>
          </TextField>
          <TextField
            select
            label="Priority"
            variant="outlined"
            size="small"
            value={priorityFilter}
            onChange={(e) => setPriorityFilter(e.target.value as Priority | 'all')}
            sx={{ minWidth: 120 }}
          >
            <MenuItem value="all">All</MenuItem>
            <MenuItem value={Priority.LOW}>Low</MenuItem>
            <MenuItem value={Priority.MEDIUM}>Medium</MenuItem>
            <MenuItem value={Priority.HIGH}>High</MenuItem>
            <MenuItem value={Priority.CRITICAL}>Critical</MenuItem>
          </TextField>
        </Box>
      </Paper>

      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Name</TableCell>
              <TableCell>Priority</TableCell>
              <TableCell>Status</TableCell>
              <TableCell>Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {testCases.map((testCase) => (
              <TableRow key={testCase.id}>
                <TableCell>{testCase.id}</TableCell>
                <TableCell>
                  <Typography variant="body2" noWrap sx={{ maxWidth: 200 }}>
                    {testCase.name}
                  </Typography>
                </TableCell>
                <TableCell>
                  <Chip
                    label={testCase.priority}
                    size="small"
                    color={getPriorityColor(testCase.priority)}
                  />
                </TableCell>
                <TableCell>
                  <Chip
                    label={testCase.status}
                    size="small"
                    color={getStatusColor(testCase.status)}
                  />
                </TableCell>
                <TableCell>
                  <IconButton
                    size="small"
                    component={Link}
                    to={`/projects/${projectId}/test-cases/${testCase.id}`}
                  >
                    <Visibility />
                  </IconButton>
                  <IconButton
                    size="small"
                    component={Link}
                    to={`/projects/${projectId}/test-cases/${testCase.id}/edit`}
                  >
                    <Edit />
                  </IconButton>
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

export default TestCases;