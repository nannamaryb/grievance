package com.pg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pg.entity.Doc;

@Repository
public interface DocRepository extends JpaRepository<Doc, Integer>{

}
