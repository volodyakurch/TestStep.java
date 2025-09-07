import React from 'react';
import { Container, Typography } from '@mui/material';

const ProjectDetails: React.FC = () => {
  return (
    <Container maxWidth="xl" sx={{ mt: 4, mb: 4 }}>
      <Typography variant="h4" component="h1">
        Project Details
      </Typography>
      <Typography>
        Project details page content goes here.
      </Typography>
    </Container>
  );
};

export default ProjectDetails;