package com.ericsson.mdc.dblink.services.orm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.mdc.dblink.entity.ResourceDetailedInformation;
import com.ericsson.mdc.dblink.framework.AbstractDao;

@SuppressWarnings("unchecked")
@Repository("resourceDetailedInformationDao")
@Transactional
public class ResourceDetailedInformationDaoImpl extends AbstractDao<String, ResourceDetailedInformation> implements ResourceDetailedInformationDao {

	@Override
	public ResourceDetailedInformation getDetailedResourceDetails(String signum) {
		return getByKey(signum);
	}

	@Override
	public List<ResourceDetailedInformation> getDetailedResourceDetailsByManager(String signum) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("lineManager", signum));
		return criteria.list();
	}

	@Override
	public void addDetailedResourceDetails(ResourceDetailedInformation details) {
		persist(details);
		
	}

	@Override
	public void updateDetailedResourceDetails(ResourceDetailedInformation details) {
		update(details);
	}

	@Override
	public List<String> getResourcesByManager(String signum) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("lineManager", signum));
		criteria.setProjection(Projections.property("signum"));
		return criteria.list();
	}

}
