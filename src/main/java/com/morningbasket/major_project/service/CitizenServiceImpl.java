package com.morningbasket.major_project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.morningbasket.major_project.dto.Citizen;
import com.morningbasket.major_project.entity.CitizenEntity;
import com.morningbasket.major_project.repository.CitizenRepsitory;

@Service
public  class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenRepsitory citizenRepo;
	
	@Override
	public Integer createApplication(Citizen citizen) {
		
		
        String  url = "http://localhost:9090/ssn/{ssn}";
		
		RestTemplate rest = new RestTemplate();
		
		ResponseEntity<String> forEntity = rest.getForEntity(url, String.class, citizen.getSsn());
		String stateName = forEntity.getBody();
		
		if("NEW JERSY".equals(stateName)) {
			CitizenEntity entity = new CitizenEntity();
			
			BeanUtils.copyProperties(citizen, entity);
			entity.setStateName(stateName);
			
			CitizenEntity save = citizenRepo.save(entity);
			
			return save.getAppId();
		}
		
		
		return 0;
		
	}
	
	
	

	
	
	
	
	}

	
		


