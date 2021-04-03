package com.ericsson.mdc.dblink.services.orm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.mdc.dblink.entity.ResourceCurrentActivity;
import com.ericsson.mdc.dblink.framework.AbstractDao;

@SuppressWarnings("unchecked")
@Repository("currentActivityDetailsDao")
@Transactional
public class CurrentActivityDetailsDaoImpl extends AbstractDao<Integer, ResourceCurrentActivity>
		implements CurrentActivityDetailsDao {

	@Override
	public void updateCurrentActivityDetails(ResourceCurrentActivity request) {
		persist(request);
	}

	@Override
	public List<ResourceCurrentActivity> getCurrentActivityDetails(String signum) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("signum", signum));
		List<ResourceCurrentActivity> activities = criteria.list();
		return activities;
	}

	@Override
	public List<ResourceCurrentActivity> getAllActivityDetails() {
		List<Object[]> result = nativeQuery(SQLConstants.GET_ALL_LATEST_MILESTONES);
		List<ResourceCurrentActivity> allActivities = new ArrayList<ResourceCurrentActivity>();
		for (Object[] res : result){
			ResourceCurrentActivity activity = new ResourceCurrentActivity();
			activity.setSignum((String) res[0]);
			activity.setUpdateTimestamp((Date) res[1]);
			activity.setResourceName((String) res[2]);
			activity.setCurrentMilestone((String) res[3]);
			activity.setChallengesFaced((String) res[4]);
			activity.setCurrentProject((String) res[5]);
			activity.setCurrentActivities((String) res[6]);
			activity.setDeadline((Date) res[7]);
			activity.setStatus((String) res[8]);
			allActivities.add(activity);
		}
		return allActivities;
			
	}

}
