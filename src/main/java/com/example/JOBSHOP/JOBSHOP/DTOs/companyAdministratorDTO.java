package com.example.JOBSHOP.JOBSHOP.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.example.JOBSHOP.JOBSHOP.models.Employer;
import com.example.JOBSHOP.JOBSHOP.models.companyField;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;

/**
 *@author BOB
 *@Function companyAdministrator DTO Class get All Information needed for companyAdministrator(employers userName,companyFields Name) 
 **/
public class companyAdministratorDTO extends UserDTO{

	//@NotBlank
	private String companyName;
	
	private List<String> employersUserName;
	
	private List<String> companyFieldsNames;
	
	private byte[] picture;
	
	
	public List<String> getEmployersUserName() {
		return employersUserName;
	}
	public void setEmployersUserName(List<String> employersUserName) {
		this.employersUserName = employersUserName;
	}
	public List<String> getCompanyFieldsNames() {
		return companyFieldsNames;
	}
	public void setCompanyFieldsNames(List<String> companyFieldsNames) {
		this.companyFieldsNames = companyFieldsNames;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<String> getEmployers() {
		return employersUserName;
	}
	public void setEmployers(List<String> employers) {
		this.employersUserName = employers;
	}
	public List<String> getCompanyFields() {
		return companyFieldsNames;
	}
	public void setCompanyFields(List<String> companyFields) {
		this.companyFieldsNames = companyFields;
	}
	
}
