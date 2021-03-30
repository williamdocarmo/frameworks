package com.ericsson.mdc.dblink.services.orm;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.mdc.dblink.entity.ResourceBasicInfo;
import com.ericsson.mdc.dblink.framework.AbstractDao;

@Repository("basicResourceDetailsDao")
@Transactional
public class BasicResourceDetailsDaoImpl extends AbstractDao<String, ResourceBasicInfo> implements BasicResourceDetailsDao {

	@Override
	public ResourceBasicInfo getBasicResourceDetails(String signum) {
		return getByKey(signum);
	}

	@Override
	public void updateBasicResourceDetails(ResourceBasicInfo request) {
		update(request);
	}

	@Override
	public void addBasicResourceDetails(ResourceBasicInfo request) {
		persist(request);
	}

}
