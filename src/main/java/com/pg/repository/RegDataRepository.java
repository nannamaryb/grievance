package com.pg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pg.entity.RegData;

@Repository
public interface RegDataRepository extends JpaRepository<RegData, Integer>{

	Boolean existsByEmail(String email);
}
