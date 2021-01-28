package com.example.MovieProject.repository;

import com.example.MovieProject.entity.Member;
import com.example.MovieProject.entity.Movie;
import com.example.MovieProject.entity.MovieImage;
import com.example.MovieProject.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);

    //@EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    @Modifying
    @Query("delete from Review mr where mr.member = :member")
    void deleteByMember(Member member);

    @Modifying
    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("delete from Review r where r.movie = :movie")
    void deleteByMovie(Movie movie);

}
