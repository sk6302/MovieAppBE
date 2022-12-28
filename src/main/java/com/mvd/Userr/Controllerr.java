package com.mvd.Userr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controllerr {

	@Autowired
	Servicee servicee;
	
	@RequestMapping(value="/getuserdata",method=RequestMethod.GET)
	public List<Userr> getuserdata(){

		List<Userr> userList = servicee.getuserdata();
		return userList;

	}
	
	@RequestMapping(value="/getmoviesdata",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

	public void postPatientData(@RequestBody Userr userr) {

		
	 servicee.getAllDataBaseName(userr);

	}
	
	@RequestMapping(value="/updateUserdata",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateUserData(@RequestBody Userr userr) {

		String statusMessage;

		if(0==userr.getId()) {
			throw new IllegalArgumentException("Id should be valid to update");
		}
		boolean status = servicee.updateUserData(userr);

		if(status) {
			statusMessage = "Data updated sucessfully...";
		}else {
			statusMessage = "Data update failed...";
		}
		return statusMessage;
	}

	
	@RequestMapping(value="/deleteUserdata",method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deleteUserData(@RequestBody Userr userr) {

		String statusMessage;

		if(0==userr.getId()) {
			throw new IllegalArgumentException("Id should be valid to update");
		}
		boolean status = servicee.deleteUserdata(userr);

		if(status) {
			statusMessage = "Data updated sucessfully...";
		}else {
			statusMessage = "Data update failed...";
		}
		return statusMessage;
	}
	
	
	
	
	
	
}
