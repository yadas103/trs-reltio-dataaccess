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
@Table(name = "TR_RELTIO.PR_TERRITORY")
public class TerritoryModel extends AbstractModel {
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="seq",sequenceName="TR_RELTIO.TR_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name = "TERRITORY_ID")
	private BigDecimal   id;
	
	@Column(name = "TERRITORY_NAME")
	private String territoryName;
	
	@Column(name = "TERRITORY_CODE")
	private String territoryCode;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getTerritoryName() {
		return territoryName;
	}

	public void setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
	}

	public String getTerritoryCode() {
		return territoryCode;
	}

	public void setTerritoryCode(String territoryCode) {
		this.territoryCode = territoryCode;
	}

	
}
