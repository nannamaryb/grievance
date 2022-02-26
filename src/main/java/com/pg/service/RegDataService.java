package com.pg.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pg.entity.District;
import com.pg.entity.Doc;
import com.pg.entity.RegData;
import com.pg.entity.State;
import com.pg.repository.DistrictRepository;
import com.pg.repository.DocRepository;
import com.pg.repository.RegDataRepository;
import com.pg.repository.StateRepository;

@Service
public class RegDataService {
	
	@Autowired
	RegDataRepository regDataDao;
	
	@Autowired
	StateRepository stateDao;
	
	@Autowired
	DistrictRepository districtDao;
	
	@Autowired
	private DocRepository docRepository;
	
	
	public void addPg(RegData regData) {
		regDataDao.save(regData);
	}

	public List<State> getAllState(){
		return stateDao.findAll();
	}
	
	public List<District> getAllDistrict(){
		return districtDao.findAll();
	} 
	
	public Doc saveFile(MultipartFile file) throws IOException {
		
		String docname = file.getOriginalFilename();
			Doc doc = new Doc(docname,file.getContentType(),file.getBytes());
			return docRepository.save(doc);
	}
}
