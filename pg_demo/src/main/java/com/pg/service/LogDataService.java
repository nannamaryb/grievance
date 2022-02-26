package com.pg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.entity.RegData;
import com.pg.repository.RegDataRepository;

@Service
public class LogDataService {
	
	@Autowired
	RegDataRepository regDataDao;
	
	public void addPg(RegData regData) {
		regDataDao.save(regData);
	}

}
