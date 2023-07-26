package org.bahmni.module.events.ipd.service;

import org.bahmni.module.events.ipd.contract.ScheduleMedicationRequest;
import org.bahmni.module.events.ipd.model.Schedule;

public interface ScheduleMedicationService {
    Schedule createSchedule(ScheduleMedicationRequest scheduleMedicationRequest);
}
