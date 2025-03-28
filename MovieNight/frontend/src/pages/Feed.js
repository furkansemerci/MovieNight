import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import {
  Box,
  Card,
  TextField,
  Typography,
  InputAdornment,
  Button,
} from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";


const Feed = () => {
  const [query, setQuery] = useState("");
  const [post, setPost] = useState(null);
  const [isLoading, setIsLoading] =useState(true);

  useEffect(() => {
    const fetchPosts = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/movies/${query}`);
        setPost(response.data);
      } catch (error) {
        console.error("Error fetching posts:", error);
      } finally {
        setIsLoading(false);
      }
    };
  
    const fetchInitialPosts = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/movies");
        console.log(response);
        setPost(response.data);
      } catch (error) {
        console.error("Error fetching initial posts:", error);
      }
    };
  
    if (query.length === 0) fetchInitialPosts();
    if (query.length > 2) fetchPosts();
  }, [query]);
  
console.log(post);
  return (
    <div className="container">
      
      <Box className="search-box">
        <TextField
          InputProps={{
            startAdornment: (
              <InputAdornment position="start">
                <SearchIcon />
              </InputAdornment>
            ),
          }}
          placeholder="Search..."
          fullWidth
          onChange={(e) => setQuery(e.target.value)}
        />
      </Box>
      <div className="post-container">
        {(post==null && isLoading==true) ? <p>Loading...</p> :
          post.map((p) => (
            <Card key={p.id} className="post-card">
              <Link to={`/details/${p.id}`}>
                  <Typography variant="h5" className="post-title">
                    {p.title}
                  </Typography>
                  <Typography className="post-description">
                    Description: {p.plot}
                  </Typography>
                  <Typography variant="h6" className="post-imdb">
                    IMDB: {p.imdb.rating}
                  </Typography>
                  <Typography className="post-genres-label">Genres:</Typography>
                  {p.genres &&
                    p.genres.map((s, i) => (
                        <Typography className="genres-listed" variant="body" gutterBottom key={i}>
                        {s} .
                        {` `}
                      </Typography>
                    ))}
              </Link>
            </Card>
          ))}
      </div>
    </div>
  );
};

export default Feed;
