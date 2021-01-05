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
@Table(name = "TR_RELTIO.PR_CUSTOM_DETAILS")
public class CustomDetailsModel extends AbstractModel {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ODS_ID")
	private BigDecimal   id;
	
	@Column(name = "FIELD_ID")
	private BigDecimal fieldId;
	
	@Column(name = "FIELD_NAME")
	private String fieldName;

	@Column(name = "FIELD_VALUE")
	private String fieldValue;

	@Column(name = "PARTY_TYPE")
	private String partyType;
	
	
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


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public String getFieldValue() {
		return fieldValue;
	}


	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}


	public String getPartyType() {
		return partyType;
	}


	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}


	public BigDecimal getFieldId() {
		return fieldId;
	}


	public void setFieldId(BigDecimal fieldId) {
		this.fieldId = fieldId;
	}
	
}
