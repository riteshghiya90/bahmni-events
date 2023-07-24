/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.bahmni.module.events.ipd.dao.impl;

import org.bahmni.module.events.ipd.dao.ScheduleDAO;
import org.bahmni.module.events.ipd.model.Schedule;
import org.hibernate.SessionFactory;
import org.openmrs.api.db.DAOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateScheduleDAO implements ScheduleDAO {
	
	private static final Logger log = LoggerFactory.getLogger(HibernateScheduleDAO.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Schedule getSchedule(Integer scheduleId) throws DAOException {
		return sessionFactory.getCurrentSession().get(Schedule.class, scheduleId);
	}
	
	@Override
	public Schedule saveSchedule(Schedule schedule) throws DAOException {
		return null;
	}
}
