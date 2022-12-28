package com.mvd.movielist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvd.Userr.Userr;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controlller {

	@Autowired
	Servicce servicce;
	
	@RequestMapping(value="/getmoviesdata",method=RequestMethod.GET)
	public List<MovieLists> getmoviesdata(){

		List<MovieLists> moviesList = servicce.getmoviesdata();
		return moviesList;

	}
	
}
