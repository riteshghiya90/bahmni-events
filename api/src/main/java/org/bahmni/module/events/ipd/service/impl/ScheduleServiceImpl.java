/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.bahmni.module.events.ipd.service.impl;

import org.bahmni.module.events.ipd.dao.ScheduleDAO;
import org.bahmni.module.events.ipd.model.Schedule;
import org.bahmni.module.events.ipd.service.ScheduleService;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScheduleServiceImpl extends BaseOpenmrsService implements ScheduleService {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduleServiceImpl.class);
	
	private final ScheduleDAO scheduleDAO;

	@Autowired
	public ScheduleServiceImpl(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}

	@Override
	@Transactional(readOnly = true)
	public Schedule getSchedule(Integer scheduleId) throws APIException {
		return scheduleDAO.getSchedule(scheduleId);
	}
	
	@Override
	public Schedule saveSchedule(Schedule schedule) throws APIException {
		return scheduleDAO.saveSchedule(schedule);
	}
}
