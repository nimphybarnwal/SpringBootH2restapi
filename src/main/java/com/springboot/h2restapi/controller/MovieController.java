package com.springboot.h2restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.h2restapi.entity.Movie;
import com.springboot.h2restapi.repository.IMovieRepo;

@RestController
@RequestMapping("/api")
public class MovieController 
{

	@Autowired
	IMovieRepo movieRepo;
	@GetMapping("/movies")
	public ResponseEntity<List<Movie>>getAllMovies()
	{
		try
		{
			List<Movie> list=movieRepo.findAll();
			if(list.isEmpty() || list.size()==0)
			{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable Long id)
	{
		Optional<Movie> movie=movieRepo.findById(id);
		
		if(movie.isPresent())
		{
			return new ResponseEntity<>(movie.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@PostMapping("/movies")
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie)
	{
		try
		{
			return new ResponseEntity<>(movieRepo.save(movie),HttpStatus.CREATED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/movies")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie)
	{
		try
		{
			return new ResponseEntity<>(movieRepo.save(movie),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@DeleteMapping("/movies/{id}")
	public ResponseEntity<HttpStatus> deleteMovie(@PathVariable Long id)
	{
	    try
	    {
		Optional<Movie> movie=movieRepo.findById(id);
		if(movie.isPresent())
		{
			movieRepo.delete(movie.get());
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }catch(Exception e)
	    {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}
