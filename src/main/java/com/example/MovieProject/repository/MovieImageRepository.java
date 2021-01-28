package com.example.MovieProject.repository;

import com.example.MovieProject.entity.Member;
import com.example.MovieProject.entity.Movie;
import com.example.MovieProject.entity.MovieImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {

    @Query("select mi from MovieImage mi where mi.movie = :movie")
    public List<MovieImage> findByMovie(Movie movie);

}

