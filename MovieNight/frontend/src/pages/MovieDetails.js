import {Link, useParams} from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";


const MovieDetails = () => {

    const [post, setPost] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    const {id} = useParams();

    useEffect(() =>{
        const fetchInitialPosts = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/movies/details/${id}`);
                console.log(response);
                setPost(response.data);
                setIsLoading(false);
            } catch (error) {
                console.error("Error fetching post:", error);
            }
        };
    
        fetchInitialPosts();
    },[id]);



    return (  
        <div className="movie-container">
            {(isLoading==true && post==null) ? <p>Loading..</p>
            :(
                <article className="movie-card">
                    <h2 className="movie-title">{post.title}</h2>
                    <p className="movie-plot"><strong>Plot Summary:</strong> {post.plot}</p>

                    <p className="movie-info"><strong>Release Year:</strong> {post.releaseYear || "N/A"}</p>
                    <p className="movie-info"><strong>Age Rating:</strong> {post.ageRating || "N/A"}</p>

                    <p className="movie-info"><strong>Languages:</strong> {post.languages?.join(", ") || "N/A"}</p>
                    <p className="movie-info"><strong>Genres:</strong> {post.genres?.join(", ") || "N/A"}</p>

                    <p className="movie-info"><strong>IMDB Rating:</strong> ⭐ {post.imdb?.rating} ({post.imdb?.votes} votes)</p>

                    <p className="movie-info"><strong>Directors:</strong> {post.directors?.join(", ") || "N/A"}</p>
                    <p className="movie-info"><strong>Cast:</strong> {post.cast?.join(", ") || "N/A"}</p>
                </article>
            )
        }
            <div className="btnHome">
                <Link to="/">Home</Link>
            </div>
        </div>

        
    );
}
 
export default MovieDetails;