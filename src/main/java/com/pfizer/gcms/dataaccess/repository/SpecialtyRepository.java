package com.pfizer.gcms.dataaccess.repository;


import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.pfizer.gcms.dataaccess.model.SpecialtyModel;

public class SpecialtyRepository extends AbstractRepository<SpecialtyModel> {
	private static final Log LOG = LogFactory.getLog(AbstractRepository.class);

	public SpecialtyRepository(Locale country) {
		setModelType(SpecialtyModel.class);
	}
	
}
