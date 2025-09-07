import React from 'react';
import { Container, Typography } from '@mui/material';

const TestRunDetail: React.FC = () => {
  return (
    <Container maxWidth="xl" sx={{ mt: 4, mb: 4 }}>
      <Typography variant="h4" component="h1">
        Test Run Detail
      </Typography>
      <Typography>
        Test run detail page content goes here.
      </Typography>
    </Container>
  );
};

export default TestRunDetail;