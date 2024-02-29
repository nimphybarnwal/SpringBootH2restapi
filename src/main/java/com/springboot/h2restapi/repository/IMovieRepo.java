package com.springboot.h2restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.h2restapi.entity.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Long> {

}
