package com.ericsson.mdc.dblink.services.orm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.mdc.dblink.entity.UserAuthData;
import com.ericsson.mdc.dblink.framework.AbstractDao;

@SuppressWarnings("unchecked")
@Repository("userAuthenticationDao")
@Transactional
public class UserAuthenticationDaoImpl extends AbstractDao<String, UserAuthData> implements UserAuthenticationDao {

	@Override
	public UserAuthData authenticateUser(String signum) {
		return getByKey(signum);
	}

	@Override
	public int addAuthInfo(UserAuthData authData) {
		persist(authData);
		return 0;
	}

	@Override
	public int changePassword(UserAuthData request) {
		update(request);
		return 0;
	}

	@Override
	public List<String> getResourceByRole(String role) {
		Criteria criteria = createEntityCriteria()
				.setProjection(Projections.projectionList().add(Projections.property("signum"), "signum"));
		criteria.add(Restrictions.like("role", role, MatchMode.ANYWHERE));
		return criteria.list();
	}

}
