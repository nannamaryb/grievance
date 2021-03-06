package com.pg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pg.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

	
}
