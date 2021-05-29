package com.ncu.model;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.ncu.validations.IsValidPassword;

public class customer {
private String fname;
	
	@NotNull(message="is required")
	@Size(min=2, message="is required")
	private String lname;
	@NotNull(message="is required")
	@Pattern(regexp= "[0-9]{10}", message="Only 10 digits allowed")
	private String pno;
	@NotNull(message="is required")
	@Pattern(regexp= "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message="email required")
	private String email;
	private String country;

	private String gender;
	
	
	
	
	public customer() {
		
		
//		countryList = new ArrayList<String>();
//	    countryList.add( "United States");
//	    countryList.add("China");
//	    countryList.add("Singapore");
//	    countryList.add("Malaysia");
//	    System.out.println("List is"+countryList);
	}
	
	//@CourseCode(value="CSE", message="must start with CSE")
	//private String courseCode;
	
	//public String getCourseCode() {
		//return courseCode;
	//}

	//public void setCourseCode(String courseCode) {
		//this.courseCode = courseCode;
	//}
	
	@NotEmpty

	@IsValidPassword
	
	private String password;
	public customer(String fname,String lname,String gender,String email,String pno,String password)
	{
		this.fname=fname;
		this.lname=lname;
		this.email=email;
		this.pno=pno;
		this.gender=gender;
		this.password=password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "customer [firstname=" + fname + ", lastname=" +lname + ", password=" + password + ", email=" + email + ", gender=" + gender + ",  pno=" + pno + "]";
	}
	
}
