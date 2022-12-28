package com.mvd.movielist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicce {

	@Autowired
	Daaoo daaoo;
	
	
	public List<MovieLists> getmoviesdata() {
		
		List<MovieLists> mvList = daaoo.getmoviesdata();
		return mvList;
	}

}
