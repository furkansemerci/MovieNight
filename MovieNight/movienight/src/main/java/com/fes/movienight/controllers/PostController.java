package com.fes.movienight.controllers;

import com.fes.movienight.models.PostModel;
import com.fes.movienight.repos.PostRepository;
import com.fes.movienight.repos.SearchRepository;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class PostController {

    @Autowired
    private PostRepository repo;

    @Autowired
    private SearchRepository srepo;

    @Hidden
    @GetMapping("api/swagger")
    @CrossOrigin
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
        System.out.println("redirected to /swagger-ui/index.html");
    }

    @GetMapping("api/movies")
    @CrossOrigin
    public List<PostModel> getAllPosts() {

        return repo.findTopNPosts(PageRequest.of(0, 10));
    }

    @GetMapping("api/movies/{text}")
    @CrossOrigin
    public List<PostModel> search(@PathVariable String text) {
        return srepo.findByText(text);
    }

    @GetMapping("api/movies/details/{id}")
    @CrossOrigin
    public ResponseEntity<PostModel> getPost(@PathVariable String id) {
        System.out.println(repo.findById(id));
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
