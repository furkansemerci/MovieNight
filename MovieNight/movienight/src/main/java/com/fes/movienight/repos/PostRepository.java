package com.fes.movienight.repos;

import com.fes.movienight.models.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import org.springframework.data.domain.Pageable;
import java.util.List;


public interface PostRepository extends MongoRepository<PostModel, String> {
    @Query("{}")
    List<PostModel> findTopNPosts(Pageable pageable);
}
