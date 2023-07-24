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

import org.bahmni.module.events.ipd.dao.SlotDAO;
import org.bahmni.module.events.ipd.model.Slot;
import org.bahmni.module.events.ipd.service.SlotService;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SlotServiceImpl extends BaseOpenmrsService implements SlotService {
	
	private static final Logger log = LoggerFactory.getLogger(SlotServiceImpl.class);
	
	private SlotDAO ipdSlotDAO;
	
	@Override
	public void setFhirSlotDao(SlotDAO slotDAO) {
		this.ipdSlotDAO = slotDAO;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Slot getSlot(Integer slotId) throws APIException {
		return ipdSlotDAO.getSlot(slotId);
	}
	
	@Override
	public Slot saveSlot(Slot slot) throws APIException {
		return ipdSlotDAO.saveSlot(slot);
	}
}