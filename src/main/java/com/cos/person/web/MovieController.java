package com.cos.person.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.person.domain.CommonDto;
import com.cos.person.domain.JoinReqDto;
import com.cos.person.domain.UpdateReqDto;
import com.cos.person.domain.Movie;
import com.cos.person.domain.MovieRepository;

@RestController
public class MovieController {

	private MovieRepository movieRepository;

	// DI = 의존성 주입
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	// http://localhost:8080/user
	@GetMapping("/movie")
	public CommonDto<List<Movie>> findAll() {
		System.out.println("findAll()");
		// return movieRepository.findAll(); 
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findAll()); 
																					
	}

	// http://localhost:8080/user/2
	@GetMapping("/movie/{id}")
	public CommonDto<Movie> findById(@PathVariable int id) {
		System.out.println("findById() : id : " + id);
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findById(id));
	}

	@CrossOrigin
	@PostMapping("/movie")
	public CommonDto<String> save(@RequestBody JoinReqDto dto) {

		movieRepository.save(dto);
		return new CommonDto<>(HttpStatus.CREATED.value(), "ok");
	}

	// http://localhost:8080/user/2
	@DeleteMapping("/movie/{id}")
	public CommonDto delete(@PathVariable int id) {
		System.out.println("delete()");
		movieRepository.delete(id);
		return new CommonDto<>(HttpStatus.OK.value());
	}

	// http://localhost:8080/user/2
	@PutMapping("/movie/{id}")
	public CommonDto update(@PathVariable int id, @RequestBody UpdateReqDto dto) {
		System.out.println("update()");
		movieRepository.update(id, dto);
		return new CommonDto<>(HttpStatus.OK.value());
	}
}
