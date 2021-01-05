package com.pfizer.gcms.dataaccess.repository;


import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pfizer.gcms.dataaccess.model.CustomFieldModel;
import com.pfizer.gcms.dataaccess.model.SpecialtyModel;

public class CustomFieldRepository extends AbstractRepository<CustomFieldModel> {
	private static final Log LOG = LogFactory.getLog(AbstractRepository.class);

	public CustomFieldRepository(Locale country) {
		setModelType(CustomFieldModel.class);
	}
	
}
