package com.pg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

  
@Entity 
@Table(name = "register",uniqueConstraints={@UniqueConstraint(columnNames={"email","name","mobile"})})
public class RegData {        
    
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id; 


	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_id")
    private Doc  doc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id")
	private State state;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id")
	private District district;
	  
	public RegData() {
		super();
		// TODO Auto-generated constructor stub
	}

	@NotBlank(message = "Name cannot be empty")
	@Size(min = 3, max = 50,message = "minimum 3 to 50 charcters")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "alphabets A-Z or a-z are allowed")
	@Column(unique = true)
	private String name;
	 
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "please enter a valid email")
	@NotBlank(message = "Email cannot be empty")
	@Column(unique = true)
	private String email;   
 
	@NotBlank(message = "Mobile cannot be empty")
	@Pattern(regexp ="(^[6-9]{1}[0-9]{9})",message="must be a valid mobile number")
	@Column(unique = true)
	private String mobile;  
	  
	@NotBlank(message = "Category cannot be empty")
	private String category;  
	 
	@NotBlank(message = "Please write your grievance here") 
	private String grievance;   
	  
	@NotBlank(message = "Pincode cannot be empty") 
	@Pattern(regexp = "(^[1-9]{1}[0-9]{5})", message="must be a valid pincode")
	private String pincode;
	 
	@AssertTrue(message = "must confirm")
	private boolean agreed;        
	       
	@NotBlank(message = "please select the gender")   
	private String gender; 
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getGender() {      
		return gender;              
	}               
         
	public void setGender(String gender) {         
		this.gender = gender; 
	}      
         
	public String getMobile() {         
		return mobile;       
	}            
           
	public void setMobile(String mobile) { 
		this.mobile = mobile;        
	}          
           
	public String getCategory() {     
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGrievance() {
		return grievance;
	}

	public void setGrievance(String grievance) {
		this.grievance = grievance;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}

	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "RegData [name=" + name + ", email=" + email + "]";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public boolean isAgreed() {
		return agreed;
	}  
 
	public void setAgreed(boolean agreed) {  
		this.agreed = agreed;
	}     
    
	public void setEmail(String email) { 
		this.email = email;
	}
	
	public Doc getDoc() {
		return doc;
	}

	public void setDoc(Doc doc) {
		this.doc = doc;
	}

	public RegData(
			@NotBlank(message = "Name cannot be empty") @Size(min = 3, max = 50, message = "minimum 3 to 50 charcters") @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "alphabets A-Z or a-z are allowed") String name,
			@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "please enter a valid email") @NotBlank(message = "Email cannot be empty") String email,
			@NotBlank(message = "Mobile cannot be empty") @Pattern(regexp = "(^[6-9]{1}[0-9]{9})", message = "must be a valid mobile number") String mobile,
			@NotBlank(message = "Category cannot be empty") String category,
			@NotBlank(message = "Please write your grievance here") String grievance,
			@NotBlank(message = "Pincode cannot be empty") @Pattern(regexp = "(^[1-9]{1}[0-9]{5})", message = "must be a valid pincode") String pincode,
			@AssertTrue(message = "must confirm") boolean agreed,
			@NotBlank(message = "please select the gender") String gender, State state, District district) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.category = category;
		this.grievance = grievance;
		this.pincode = pincode;
		this.agreed = agreed;
		this.gender = gender;
		this.state = state;
		this.district = district;
	}

	      
	
}
