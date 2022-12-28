package com.mvd.Userr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;


@Component
public class Daoo {

	@Autowired
	JdbcTemplate template;
	
	public List<Userr> getuserdata() {
List<Userr> patList = new ArrayList<>();
		
		return template.query("select * from movie.user", new ResultSetExtractor<List<Userr>>() {

			@Override
			public List<Userr> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					Userr userr = new Userr();
					userr.setId(rs.getInt("id"));
					userr.setName(rs.getString("name"));
					userr.setEmail(rs.getString("email"));
					userr.setPassword(rs.getString("password"));
					patList.add(userr);
				}
		return patList;
	}

});
		
	}

	public boolean saveToMovieTable(Userr userr) {
		
		boolean status = false;
		
		String sql = "insert into movie.user(id,name,email,password) " 
				+ "values("
				+"'"+userr.getId() +"'"
				+",'"+userr.getName() +"'"
				+",'"+userr.getEmail() +"'"
				+",'"+userr.getPassword() +"'"
				+")";
		
		try{
		template.execute(sql);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return status;
	}


	public boolean updateUserData(Userr userr) {
		
		boolean status = false;

		String sql = "update movie.user set Name = '"+ 
				userr.getName()+"' where Id = "+userr.getId();

		try {
			template.execute(sql);
			status = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	

	public boolean deleteUserdata(Userr userr) {

		boolean status = false;

		String sql = "update movie.user set Name = '"+ 
				userr.getName()+"' where Id = "+userr.getId();

		try {
			template.execute(sql);
			status = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	
	

	

	
}
	