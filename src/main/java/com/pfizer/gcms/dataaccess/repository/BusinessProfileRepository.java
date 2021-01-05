package com.pfizer.gcms.dataaccess.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;

import com.pfizer.gcms.dataaccess.common.exception.GCMSBadDataException;
import com.pfizer.gcms.dataaccess.dto.BusinessProfileDisplayDTO;
import com.pfizer.gcms.dataaccess.model.BusinessProfileModel;

/**
 * @author VENKAD09 The Business Profile Repository will provide methods for
 *         accessing data stored in the database.
 */

public class BusinessProfileRepository extends AbstractRepository<BusinessProfileModel> {

	private static final Log LOG = LogFactory.getLog(AbstractRepository.class);

	/**
	 * Creates a new instance of the BusinessProfileRepository and configures
	 * the abstract class with the correct models.
	 * 
	 */

	public BusinessProfileRepository() {
		LOG.debug("Inside method BusinessProfileRepository()");
		setModelType(BusinessProfileModel.class);
	}

	/**
	 * @author VENKAD09
	 * @param String name, String type, String lastName, String city,String firstName, String address
	 * @return List of Business Profile Models
	 * @throws Exception
	 * @description findByCountry method to search for Business Profiles by Reporting Country
	 */

	@SuppressWarnings("unchecked")
	@Override
	public  List<BusinessProfileDisplayDTO> findByCountry(String name,String type,String lastName, String city,String firstName,String address,String speciality ) throws Exception {
		LOG.debug("Inside method List<BusinessProfileModel> findByCountry(String name,String type,String lastName, String city,String firstName,String address,String speciality )" );
		BigDecimal zero = BigDecimal.ZERO;
			if (name == null || name.trim().isEmpty()) {
				String message = "Invalid Country Name";
				LOG.warn(message);
				throw new GCMSBadDataException(message);
			}
			
			EntityManager entityManager = getEntityManager();
			LOG.debug("entityManager"+entityManager);
			List<BusinessProfileDisplayDTO> models = null;
				
			try {
				
				Session session = entityManager.unwrap(org.hibernate.Session.class);
				SessionFactory sessionFactory = session.getSessionFactory();
				SessionFactoryImplementor impl = (SessionFactoryImplementor)sessionFactory;
				ConnectionProvider cp = impl.getConnectionProvider();
				Connection conn = cp.getConnection();
				String sqlString = "query in here";
				conn.setAutoCommit(false);

				// create the statement object  
				Statement stmt=conn.createStatement(); 		
				
				
				String searchBPQuery = "select BP_ID, PROFILE_TYPE_ID, FIRST_NAME, LAST_NAME,ORGANISATION_NAME,CITY, ADDR_LN_1_TXT,SPECIALITY from GCMS_ODS.GCMS_BUS_PROFILE_MVIEW_NEW  where COUNTRY= '"+name.trim()+"' and PROFILE_TYPE_ID= '"+type.trim()+"'  " ;
				if(lastName != null && !lastName.equals("lastName")){
				lastName = '%'+lastName+'%';	
				searchBPQuery = searchBPQuery + " and( " + 
						"  upper(LAST_NAME) like upper('"+lastName.trim()+"') " + 
						"	  or upper(ORGANISATION_NAME) like upper('"+lastName.trim()+"') " + 
						"	 )";			
				}
				if(city != null && !city.equals("city")){
					city = '%'+city+'%';
					searchBPQuery = searchBPQuery + " and UPPER(CITY) LIKE UPPER('"+city.trim()+"')";
				
				}
				if(firstName != null && !firstName.equals("firstName")){
					firstName = '%'+firstName+'%';
					searchBPQuery = searchBPQuery + " and UPPER(FIRST_NAME) LIKE UPPER('"+firstName.trim()+"')";
				
				}
				if(address != null && !address.equals("address")){
					address = '%'+address+'%';
					searchBPQuery = searchBPQuery + " and UPPER(ADDR_LN_1_TXT) LIKE UPPER('"+address.trim()+"')";
				
				}
				if(speciality != null && !speciality.equals("speciality")){
					speciality = '%'+speciality+'%';
					searchBPQuery = searchBPQuery + " and UPPER(SPECIALITY) LIKE UPPER('"+speciality.trim()+"')";
				
				}
				PreparedStatement pStmt = conn.prepareStatement(searchBPQuery);
				
							
				LOG.info("Before time execute" + new Date().toString());
				LOG.info("Query executed " + searchBPQuery);
				
				// execute query  
				ResultSet resultSet = pStmt.executeQuery(); 
				resultSet.setFetchSize(10000);
				LOG.info("After query execute" + new Date().toString() );
				models = new ArrayList<BusinessProfileDisplayDTO>();
				while(resultSet.next()) {
					// Populate Business Profile DTO to be send to service layer
					BusinessProfileDisplayDTO bp = new BusinessProfileDisplayDTO();
					bp.setId(resultSet.getBigDecimal("BP_ID"));
					bp.setProfileType(resultSet.getString("PROFILE_TYPE_ID"));
					bp.setFirstName(resultSet.getString("FIRST_NAME"));
					bp.setLastName(resultSet.getString("LAST_NAME"));
					bp.setOrganisationName(resultSet.getString("ORGANISATION_NAME"));
					bp.setCity(resultSet.getString("CITY"));
					bp.setAddress(resultSet.getString("ADDR_LN_1_TXT"));
					bp.setSpeciality(resultSet.getString("SPECIALITY"));
					models.add(bp);
				}
				
				// close the connection object 
				resultSet.close();
				pStmt.close();
				conn.close();  
				LOG.info("After closing connection" + new Date().toString() );
				
			} catch (Exception e) {
				LOG.debug(e.getStackTrace());
			}
						
			LOG.debug("models" +models);
			if (models == null || models.isEmpty()) {
				return null;
			}
			return models;
		}
	/**
	 * @author KHANS129
	 * @param BigDecimal[] id
	 * @return List of Business Profile Models
	 * @throws Exception
	 * @description findById method to search for Business Profiles by array of id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BusinessProfileModel> findById(BigDecimal[] id) throws Exception {
		LOG.debug("Inside method List<BusinessProfileModel> findById(BigDecimal[] id )");
		if (id == null) {
			String message = "Invalid selection";
			LOG.warn(message);
			throw new GCMSBadDataException(message);
		}
		EntityManager entityManager = getEntityManager();
		List<BusinessProfileModel> models = null;
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<BusinessProfileModel> query = criteria.createQuery(getModelType());
		Root<BusinessProfileModel> root = query.from(getModelType());
		Expression<BigDecimal[]> idExp = root.get(BusinessProfileModel.FIELD_BP_ID);
		List<BigDecimal> ids = Arrays.asList(id);
		Query typedQuery = entityManager.createQuery("FROM com.pfizer.gcms.dataaccess.model.BusinessProfileModel WHERE id IN (:ids)");
		typedQuery.setParameter("ids", ids);
		models = typedQuery.getResultList();
		LOG.debug("models" + models);
		if (models == null || models.isEmpty()) {
			return null;
		}
		return models;
	}

	/**
	 * @Kaswas
	 * @param bpid
	 * @return profile of that particular bpid
	 * @throws Exception
	 * @description this method is used to get data for one particular Bpid from
	 *              BusinessProfile table for validation in Profile Review
	 */
	public List<BusinessProfileModel> validationfindById(BigDecimal id) throws Exception {
		LOG.debug("Inside method List<BusinessProfileModel> validationfindById(BigDecimal id )");
		if (id == null) {
			String message = "Invalid selection";
			LOG.warn(message);
			throw new GCMSBadDataException(message);
		}

		EntityManager entityManager = getEntityManager();		
		List<BusinessProfileModel> models = null;
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();		
		CriteriaQuery<BusinessProfileModel> query = criteria.createQuery(getModelType());
		Root<BusinessProfileModel> root = query.from(getModelType());
		Expression<BigDecimal> idExp = root.get(BusinessProfileModel.FIELD_BP_ID);
		List<BigDecimal> ids = Arrays.asList(id);
		Query typedQuery = entityManager
				.createQuery("FROM com.pfizer.gcms.dataaccess.model.BusinessProfileModel WHERE id IN (:ids)");
		typedQuery.setParameter("ids", ids);
		models = typedQuery.getResultList();
		LOG.debug("models" + models);
		if (models == null || models.isEmpty()) {
			return null;
		}
		return models;
	}
}
