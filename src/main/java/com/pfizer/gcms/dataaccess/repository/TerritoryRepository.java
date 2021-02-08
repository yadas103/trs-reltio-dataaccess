package com.pfizer.gcms.dataaccess.repository;


import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.pfizer.gcms.dataaccess.model.TerritoryModel;

public class TerritoryRepository extends AbstractRepository<TerritoryModel> {
	private static final Log LOG = LogFactory.getLog(AbstractRepository.class);

	public TerritoryRepository(Locale country) {
		setModelType(TerritoryModel.class);
	}
	
}
