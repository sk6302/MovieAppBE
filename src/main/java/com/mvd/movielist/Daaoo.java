package com.mvd.movielist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;


@Component
public class Daaoo {

	@Autowired
	JdbcTemplate template;
	
	public List<MovieLists> getmoviesdata() {
		
		List<MovieLists> movList = new ArrayList<>();
		
		return template.query("select * from movie.movieslist", new ResultSetExtractor<List<MovieLists>>() {

			@Override
			public List<MovieLists> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				while(rs.next()) {
					MovieLists movieLists = new MovieLists();
					movieLists.setMovieid(rs.getInt("movieid"));
					movieLists.setMoviename(rs.getString("moviename"));
					movieLists.setMovieLanguage(rs.getString("movieLanguage"));
					movieLists.setMoviebudget(rs.getString("moviebudget"));
					movieLists.setMoviedirector(rs.getString("moviedirector"));
					movieLists.setMovietrending(rs.getString("movietrending"));
					movieLists.setMoviecategory(rs.getString("moviecategory"));
					movieLists.setReleaseyear(rs.getString("releaseyear"));
					movieLists.setMovierating(rs.getString("movierating"));
					movList.add(movieLists);
				}
				return movList;
			}
			
		});
	
	}

}
