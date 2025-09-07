import React from 'react';
import {
  Container,
  Typography,
  Grid,
  Paper,
  Box,
} from '@mui/material';
import {
  Assignment as ProjectIcon,
  PlaylistAddCheck as TestCaseIcon,
  PlaylistPlay as TestRunIcon,
  CheckCircle as TestResultIcon,
} from '@mui/icons-material';

const Dashboard: React.FC = () => {
  const stats = [
    { title: 'Projects', value: '5', icon: <ProjectIcon fontSize="large" />, color: '#1976d2' },
    { title: 'Test Cases', value: '128', icon: <TestCaseIcon fontSize="large" />, color: '#2e7d32' },
    { title: 'Test Runs', value: '24', icon: <TestRunIcon fontSize="large" />, color: '#ed6c02' },
    { title: 'Test Results', value: '1,248', icon: <TestResultIcon fontSize="large" />, color: '#d32f2f' },
  ];

  return (
    <Container maxWidth="xl" sx={{ mt: 4, mb: 4 }}>
      <Typography variant="h4" component="h1" gutterBottom>
        Dashboard
      </Typography>
      
      <Grid container spacing={3}>
        {stats.map((stat) => (
          <Grid item xs={12} sm={6} md={3} key={stat.title}>
            <Paper
              sx={{
                p: 2,
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
              }}
            >
              <Box sx={{ color: stat.color, mb: 1 }}>
                {stat.icon}
              </Box>
              <Typography component="h2" variant="h6" color="primary" gutterBottom>
                {stat.title}
              </Typography>
              <Typography component="p" variant="h4">
                {stat.value}
              </Typography>
            </Paper>
          </Grid>
        ))}
      </Grid>

      <Grid container spacing={3} sx={{ mt: 1 }}>
        <Grid item xs={12} md={6}>
          <Paper sx={{ p: 2, display: 'flex', flexDirection: 'column' }}>
            <Typography variant="h6" gutterBottom>
              Recent Test Runs
            </Typography>
            <Typography color="textSecondary">
              No recent test runs
            </Typography>
          </Paper>
        </Grid>
        <Grid item xs={12} md={6}>
          <Paper sx={{ p: 2, display: 'flex', flexDirection: 'column' }}>
            <Typography variant="h6" gutterBottom>
              System Status
            </Typography>
            <Typography color="textSecondary">
              All systems operational
            </Typography>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
};

export default Dashboard;