package com.mvd.Userr;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicee {
	
	@Autowired
	Daoo daoo;

	public List<Userr> getuserdata() {

		List<Userr> usList = daoo.getuserdata();
		return usList;
	}

	public boolean getAllDataBaseName(Userr userr) {
		return daoo.saveToMovieTable(userr);
		
	}

		
	public boolean updateUserData(Userr userr) {
		
			return daoo.updateUserData(userr);

	
	}

	
	
	public boolean deleteUserdata(Userr userr) {
	
			return daoo.deleteUserdata(userr);
		
	}

}
