import React from 'react';
import { Container, Typography } from '@mui/material';

const TestCaseDetail: React.FC = () => {
  return (
    <Container maxWidth="xl" sx={{ mt: 4, mb: 4 }}>
      <Typography variant="h4" component="h1">
        Test Case Detail
      </Typography>
      <Typography>
        Test case detail page content goes here.
      </Typography>
    </Container>
  );
};

export default TestCaseDetail;