package org.bahmni.module.events.ipd.service.impl;

import org.bahmni.module.events.ipd.contract.ScheduleMedicationRequest;
import org.bahmni.module.events.ipd.mapper.ScheduleMapperService;
import org.bahmni.module.events.ipd.model.Schedule;
import org.bahmni.module.events.ipd.service.ScheduleMedicationService;
import org.bahmni.module.events.ipd.service.ScheduleService;
import org.openmrs.DrugOrder;
import org.openmrs.Order;
import org.openmrs.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleMedicationServiceImpl implements ScheduleMedicationService {

    private final ScheduleService scheduleService;
    private final ScheduleMapperService scheduleMapperService;

    @Autowired
    public ScheduleMedicationServiceImpl(ScheduleService scheduleService, ScheduleMapperService scheduleMapperService) {
        this.scheduleService = scheduleService;
        this.scheduleMapperService = scheduleMapperService;
    }

    @Override
    public Schedule createSchedule(ScheduleMedicationRequest scheduleMedicationRequest) {

        Schedule schedule = scheduleMapperService.mapScheduleMedicationRequestToSchedule(scheduleMedicationRequest);
        return scheduleService.saveSchedule(schedule);
    }
}


        /*FhirReference openmrsForReference = new FhirReference();
        openmrsForReference.setType(Patient.class.getTypeName());
        openmrsForReference.setReference(scheduleMedicationRequest.getPatientUuid());
        openmrsForReference.setName(openmrsForReference.getType() + "/" + openmrsForReference.getReference());

        FhirReference openmrsByReference = new FhirReference();
        openmrsByReference.setType(Patient.class.getTypeName());
        openmrsByReference.setReference(scheduleMedicationRequest.getPatientUuid());
        openmrsByReference.setName(openmrsByReference.getType() + "/" + openmrsByReference.getReference());*/

        /*
        List<Slot> slots = new ArrayList<>();
        for (int i = 0; i < scheduleMedicationRequest.getSlots().size(); i++) {
            Slot slot = new Slot();
            slot.setStartDate(scheduleMedicationRequest.getSlots().get(i));
            slot.setEndDate(scheduleMedicationRequest.getSlots().get(i));
            slot.setStatus(SCHEDULED);
            slot.setSchedule(schedule);
            slot.setServiceTypeId(concept);
            slot.setOrderId(order);
            //fhirSlot.location
            slots.add(slot);
        }
        return null;
         */

         /*
         Patient patient = patientService.getPatientByUuid(scheduleMedicationRequest.getPatientUuid());
        Provider provider = providerService.getProviderByUuid(scheduleMedicationRequest.getProviderUuid());
          Concept concept = conceptService.getConceptByName(MAR_CONCEPT_NAME);
          */

          /*
          private final ConceptService conceptService;

    private final PatientService patientService;

    private final ProviderService providerService;
      private final String MAR_CONCEPT_NAME = "MAR";
      private final SlotService slotService;
           */