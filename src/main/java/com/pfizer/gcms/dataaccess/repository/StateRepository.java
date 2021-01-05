package com.pfizer.gcms.dataaccess.repository;


import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pfizer.gcms.dataaccess.model.CredentialModel;
import com.pfizer.gcms.dataaccess.model.SpecialtyModel;
import com.pfizer.gcms.dataaccess.model.StateModel;

public class StateRepository extends AbstractRepository<StateModel> {
	private static final Log LOG = LogFactory.getLog(AbstractRepository.class);

	public StateRepository(Locale country) {
		setModelType(StateModel.class);
	}
	
}
