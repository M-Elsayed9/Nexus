import React from "react";
import { Grid } from '@mui/material';
import MultiActionAreaCard from '../components/MultiActionAreaCard'; 

export default function GalleryViewPage() {
  const hardcodedCardData = [
    {
      description: "Small Office with Private Desks",
      capacity: "23",
      price: "$2000",
      image: "https://images.unsplash.com/photo-1562664377-709f2c337eb2?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
      action1: {
        label: "View",
        onClick: () => {
          // Handle action 1 click
        }
      },
      action2: {
        label: "Book",
        onClick: () => {
          // Handle action 2 click
        }
      }
    },
    {
      description: "Private Corporate Office with a balcony",
      capacity: "23",
      price: "$2000",
      image: "https://images.unsplash.com/photo-1562664377-709f2c337eb2?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
      action1: {
        label: "View",
        onClick: () => {
          // Handle action 1 click
        }
      },
      action2: {
        label: "Book",
        onClick: () => {
          // Handle action 2 click
        }
      }
    },
    {
      description: "Private Working Room with Attached Bathroom",
      capacity: "23",
      price: "$2000",
      image: "https://images.unsplash.com/photo-1562664377-709f2c337eb2?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
      action1: {
        label: "View",
        onClick: () => {
          // Handle action 1 click
        }
      },
      action2: {
        label: "Book",
        onClick: () => {
          // Handle action 2 click
        }
      }
    },
    {
      description: "Private Office overseeing the New York Skyline",
      capacity: "23",
      price: "$2000",
      image: "https://images.unsplash.com/photo-1562664377-709f2c337eb2?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
      action1: {
        label: "View",
        onClick: () => {
          // Handle action 1 click
        }
      },
      action2: {
        label: "Book",
        onClick: () => {
          // Handle action 2 click
        }
      }
    },
    {
      description: "Medium Office for Startups",
      capacity: "23",
      price: "$2000",
      image: "https://images.unsplash.com/photo-1562664377-709f2c337eb2?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
      action1: {
        label: "View",
        onClick: () => {
          // Handle action 1 click
        }
      },
      action2: {
        label: "Book",
        onClick: () => {
          // Handle action 2 click
        }
      }
    },
  ];

  return (
    <Grid container spacing={0}>
      {hardcodedCardData.map((cardInfo, index) => (
        <Grid item key={index} xs={12} sm={6} md={3}>
          <MultiActionAreaCard {...cardInfo} />
        </Grid>
      ))}
    </Grid>
  );
}
