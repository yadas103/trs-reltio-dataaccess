package com.pfizer.gcms.dataaccess.dto;

import java.math.BigDecimal;

import com.pfizer.gcms.dataaccess.model.BusinessProfileModel;

/**
 * BusinessProfileSearchDTO used for Business Profile search
 */
public class BusinessProfileSearchDTO extends BaseSearchDTO<BusinessProfileModel> {

	private static final long serialVersionUID = 1L;
	public static final String FIELD_COUNTRY_NAME = "country";
	public static final String FIELD_PROFILE_TYPE = "profileType";
	public static final String FIELD_BP_ID = "id";

	private String country;
	private String profileType;
	private String lastName;
	private String middleName;
	private String credential;
	private String organizationName;
	private String organizationType;
	private String city;
	private String firstName;
	private String uniqueType;
	private String speciality;
	private String poCode;
	private String identificationNumber;
	
	public String getProfileType() {
		return profileType;
	}

	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getUniqueType() {
		return uniqueType;
	}

	public void setUniqueType(String uniqueType) {
		this.uniqueType = uniqueType;
	}

	public String getPoCode() {
		return poCode;
	}

	public void setPoCode(String poCode) {
		this.poCode = poCode;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
}
