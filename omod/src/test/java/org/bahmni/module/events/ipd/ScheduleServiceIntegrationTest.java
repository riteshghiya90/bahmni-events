package org.bahmni.module.events.ipd;

import org.bahmni.module.events.ipd.model.Reference;
import org.bahmni.module.events.ipd.model.Schedule;
import org.bahmni.module.events.ipd.service.ScheduleService;
import org.junit.Test;
import org.openmrs.Concept;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ScheduleServiceIntegrationTest extends BaseIntegrationTest {

    /*@Autowired
    private ScheduleService scheduleService;

    @Test
    public void test() {
        Schedule schedule = new Schedule();

        Reference openmrsForReference = new Reference();
        openmrsForReference.setType(Patient.class.getTypeName());
        openmrsForReference.setTargetUuid("patient-uuid-1");
        openmrsForReference.setName(openmrsForReference.getType() + "/" + openmrsForReference.getReference());

        Reference openmrsByReference = new Reference();
        openmrsByReference.setType(Patient.class.getTypeName());
        openmrsByReference.setTargetUuid("provider-uuid-1");
        openmrsByReference.setName(openmrsByReference.getType() + "/" + openmrsByReference.getReference());

        schedule.setForReference(openmrsForReference);
        schedule.setByReference(openmrsByReference);
        schedule.setStartDate(Date.from(Instant.now().plusSeconds(2)));
        schedule.setEndDate(Date.from(Instant.now().plusSeconds(5)));
        schedule.setActive(true);

        List<Concept> allConcepts = Context.getConceptService().getAllConcepts();
        schedule.setServiceType(allConcepts.get(0));
        schedule.setServiceCategory(allConcepts.get(1));
        schedule.setSpeciality(allConcepts.get(2));

        Schedule savedSchedule = scheduleService.saveSchedule(schedule);

        scheduleService.getSchedule(savedSchedule.getId());
    }*/
}
