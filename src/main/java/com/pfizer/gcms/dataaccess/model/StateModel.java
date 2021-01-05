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
@Table(name = "TR_ODS.ODS_STATE")
public class StateModel extends AbstractModel {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="seq",sequenceName="TR_RELTIO.TR_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name = "ST_ID")
	private BigDecimal   id;
	
	@Column(name = "STATE_CD")
	private String stateCode;

	@Column(name = "STATE_NM")
	private String stateDesc;

	@Column(name = "BATCH_ID")
	private BigDecimal batchId;
	
	@Column(name = "CNTRY_ID")
	private BigDecimal countryId;
	
	@Column(name = "DELETE_FLAG")
	private String delete;

	@Column(name = "COMMENTS")
	private String comments;
	
	@Column(name = "RPRTBL_STATE_CD")
	private String reportableCode;
	
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
	
	public BigDecimal getBatchId() {
		return batchId;
	}


	public void setBatchId(BigDecimal batchId) {
		this.batchId = batchId;
	}

	public BigDecimal getCountryId() {
		return countryId;
	}


	public void setCountryId(BigDecimal countryId) {
		this.countryId = countryId;
	}


	public String getDelete() {
		return delete;
	}


	public void setDelete(String delete) {
		this.delete = delete;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getStateCode() {
		return stateCode;
	}


	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}


	public String getStateDesc() {
		return stateDesc;
	}


	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}


	public String getReportableCode() {
		return reportableCode;
	}


	public void setReportableCode(String reportableCode) {
		this.reportableCode = reportableCode;
	}

}
