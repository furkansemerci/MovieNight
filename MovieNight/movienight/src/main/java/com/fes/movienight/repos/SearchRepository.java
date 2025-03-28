package com.fes.movienight.repos;

import com.fes.movienight.models.PostModel;

import java.util.List;


public interface SearchRepository {

    List<PostModel> findByText(String text);
}
