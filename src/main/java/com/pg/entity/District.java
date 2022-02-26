package com.pg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "district")
public class District {  
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	@Column(name="state_id") 
	int stateId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	State state;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) { 
		this.id = id;
	}
	public String getName() {
		return name;
	} 
	public void setName(String name) {
		this.name = name;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	} 
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	} 
}
