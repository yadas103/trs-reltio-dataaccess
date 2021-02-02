package com.pfizer.gcms.dataaccess.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * @author KASWAS
 *ProfileRequestModel is a POJO classes,annotated with hibernate mappings and they are responsible for 
 * holding instances of data objects.
 */
@Entity
@Table(name = "TR_RELTIO.PR_PROFILE_REQUEST")
public class ProfileRequestModel extends AbstractModel {
	
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="seq",sequenceName="TR_RELTIO.TR_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name = "PROFILE_REQ_ID")
	private BigDecimal   id;
	
	@Column(name = "PROFILE_TYPE_ID")
	private String   profileTypeId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	@Column(name = "ORGANISATION_NAME")
	private String organizationName;
	
	@Column(name = "ORGANISATION_TYPE")
	private String organizationType;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "COUNTRY_CODE")
	private String countryCode;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "ADDRESS_LINE1")
	private String addr1;
	
	@Column(name = "ADDRESS_LINE2")
	private String addr2;
	
	@Column(name = "ADDRESS_LINE3")
	private String addr3;

	@Column(name = "CITY")
	private String city;

	@Column(name = "SPECILITY")
	private String speciality;

	@Column(name = "ZIP")
	private String poCode;	

	@Column(name = "SUFFIX")
	private String suffix;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "CREDENTIAL")
	private String credential;
	
	@Column(name = "REGION")
	private String region;
	
	@Column(name = "UNIQUE_IDENTIFIER")
	private String uniqueIdentifier;
	
	@Column(name = "RELTIO_RES_MSG")
	private String reltioMsg;
	
	@Column(name = "RELTIO_RES_CD")
	private String reltioCode;
	
	@Column(name = "CUSTOM_DETAILS")
	private String customDet;
	
	/**
	 * @return the profileReqId
	 */
	public BigDecimal getId() {
		return id;
	}


	/**
	 * @param profileReqId the profileReqId to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/**
	 * @return the profileTypeId
	 */
	public String getProfileTypeId() {
		return profileTypeId;
	}

	/**
	 * @param profileTypeId the profileTypeId to set
	 */
	public void setProfileTypeId(String profileTypeId) {
		this.profileTypeId = profileTypeId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	
	

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getOrganizationType() {
		return organizationType;
	}


	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}


	public String getAddr1() {
		return addr1;
	}


	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}


	public String getAddr2() {
		return addr2;
	}


	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}


	public String getAddr3() {
		return addr3;
	}


	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}


	public String getPoCode() {
		return poCode;
	}


	public void setPoCode(String poCode) {
		this.poCode = poCode;
	}


	public String getSuffix() {
		return suffix;
	}


	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCredential() {
		return credential;
	}


	public void setCredential(String credential) {
		this.credential = credential;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}


	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}


	public String getReltioMsg() {
		return reltioMsg;
	}


	public void setReltioMsg(String reltioMsg) {
		this.reltioMsg = reltioMsg;
	}


	public String getReltioCode() {
		return reltioCode;
	}


	public void setReltioCode(String reltioCode) {
		this.reltioCode = reltioCode;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCustomDet() {
		return customDet;
	}


	public void setCustomDet(String customDet) {
		this.customDet = customDet;
	}

	
}
