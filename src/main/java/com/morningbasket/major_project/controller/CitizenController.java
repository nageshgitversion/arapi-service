package com.morningbasket.major_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.morningbasket.major_project.dto.Citizen;
import com.morningbasket.major_project.service.CitizenService;

@RestController
@RequestMapping
public class CitizenController {
	
	@Autowired
	public CitizenService citizenService;
	
	
	@PostMapping("/createssn")
	public ResponseEntity<String> createAppId(@RequestBody Citizen citizen){
		
		Integer appId = citizenService.createApplication(citizen);
		
		if(appId>0) {
			
			return new ResponseEntity<>("appId created: "+appId,HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Invalid SSN",HttpStatus.BAD_REQUEST);
	}

}
