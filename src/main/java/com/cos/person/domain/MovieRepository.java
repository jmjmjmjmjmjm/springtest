package com.cos.person.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

	public List<Movie> findAll(){
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1, "영화1", 3.4, "now()"));
		movies.add(new Movie(2, "영화2", 3.5, "now()"));
		movies.add(new Movie(3, "영화3", 3.6, "now()"));
		return movies;
	}
	
	public Movie findById(int id){
		return new Movie(1, "영화1", 3.7, "0102222");
	}
	
	public void save(JoinReqDto dto) {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(4, "영화1", 3.4, "now()"));
	}
	
	public void delete(int id) {
		System.out.println("DB에 삭제하기");
	}
	
	public void update(int id, UpdateReqDto dto) {
		// DAO연결해서 실행하다가 익섹션 터짐
		throw new IllegalArgumentException("아규먼트를 잘못 넣음");
		//System.out.println("DB에 수정하기");
	}
}
