package com.pg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Docs")
public class Doc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String docname;
	private String docType;

	@Lob 
	private byte[] data;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL, mappedBy = "doc")
	private RegData regData;
	 
	public Doc() {
		super();
		// TODO Auto-generated constructor stub
	} 
	public Doc(String docname, String docType, byte[] data) {
		super();
		this.docname = docname;
		this.docType = docType;
		this.data = data;
	}

	public Integer getId() { 
		return id;
	} 
 
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	public RegData getRegData() {
		return regData;
	}
	public void setRegData(RegData regData) {
		this.regData = regData;
	}	
	
	
}
