import React from "react";
import PropTypes from 'prop-types';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';

export default function MultiActionAreaCard({ description, capacity, price, image, action1, action2 }) {
  return (
    <Card sx={{ maxWidth: 345 }} className='m-8'>
      <CardActionArea>
        <CardMedia
          component="img"
          height="140"
          image={image}
          alt={description}
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {description}
          </Typography>
          <Typography variant="h6" color="text.secondary">
            Capacity: {capacity}
          </Typography>
          <Typography variant="h5" color="text.secondary">
            Price: {price}
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button size="large" color="primary" variant='contained' onClick={action1.onClick}>
          {action1.label}
        </Button>
        <Button size="large" color="success" variant='contained' onClick={action2.onClick}>
          {action2.label}
        </Button>
      </CardActions>
    </Card>
  );
}

MultiActionAreaCard.propTypes = {
  description: PropTypes.string.isRequired,
  capacity: PropTypes.string.isRequired,
  price: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
  action1: PropTypes.shape({
    label: PropTypes.string.isRequired,
    onClick: PropTypes.func.isRequired
  }).isRequired,
  action2: PropTypes.shape({
    label: PropTypes.string.isRequired,
    onClick: PropTypes.func.isRequired
  }).isRequired
};
