/**
 * 
 */
package com.pfizer.gcms.dataaccess.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author rtalapaneni
 * UserModel is a POJO classes,annotated with hibernate mappings and they are responsible for 
 * holding instances of data objects.This holds the User data object.
 */
@Entity
@Table(name = "TR_ODS.ODS_USERS")
public class UserModel extends AbstractModel {
	/**
	 * The constant user profiles.
	 */
	public static final String FIELD_USERPROFILES = "userProfiles";
	/**
	 * The constant user name.
	 */
	public static final String FIELD_USERNAME = "userName";
	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "USRNM")
	private String userName;

	@Column(name = "FRS_NM")
	private String firstName;

	@Column(name = "LST_NM")
	private String lastName;

	@Column(name = "MDL_NM")
	private String middleName;

	@Column(name = "SFX")
	private String suffix;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserProfileModel> userProfiles;

	/**
	 * Default constructor.
	 */
	public UserModel() {
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
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
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @param suffix
	 *            the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * @return the userProfiles
	 */
	public List<UserProfileModel> getUserProfiles() {
		return userProfiles;
	}

	/**
	 * @param userProfiles
	 *            the userProfiles to set
	 */
	public void setUserProfiles(List<UserProfileModel> userProfiles) {
		this.userProfiles = userProfiles;
	}

	/**
	 * Updates child references with current object.
	 */
	@Override
	public Map<Class<?>, List<BigDecimal>> updateChildReferences() {
		Map<Class<?>, List<BigDecimal>> childEntitiesToBeDeleted = new HashMap<Class<?>, List<BigDecimal>>();
		if (userProfiles != null && !userProfiles.isEmpty()) {
			List<BigDecimal> ids = new ArrayList<BigDecimal>();
			Iterator<UserProfileModel> iterator = userProfiles.iterator();
			while (iterator.hasNext()) {
				UserProfileModel model = iterator.next();
				/*if (model.isDeleteRecord()) {
					ids.add(model.getId());
					iterator.remove();
				} else { */
					model.setUser(this); 
					//}
				Map<Class<?>, List<BigDecimal>> userProfilesChildEntities  = model.updateChildReferences();
				childEntitiesToBeDeleted.putAll(userProfilesChildEntities);
			}
			childEntitiesToBeDeleted.put(UserProfileModel.class, ids);
		}
		return childEntitiesToBeDeleted;
	}
}
