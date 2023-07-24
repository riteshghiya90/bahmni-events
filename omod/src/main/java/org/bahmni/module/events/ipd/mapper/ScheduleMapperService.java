package org.bahmni.module.events.ipd.mapper;

import org.bahmni.module.events.ipd.contract.ScheduleMedicationRequest;
import org.bahmni.module.events.ipd.model.Reference;
import org.bahmni.module.events.ipd.model.Schedule;
import org.openmrs.Order;
import org.openmrs.Patient;
import org.openmrs.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapperService {

    private final OrderService orderService;

    @Autowired
    public ScheduleMapperService(OrderService orderService) {
        this.orderService = orderService;
    }

    public Schedule mapScheduleMedicationRequestToAppointment(ScheduleMedicationRequest scheduleMedicationRequest) {
        Schedule schedule = new Schedule();

        // get start date from order
        Order order = orderService.getOrderByUuid(scheduleMedicationRequest.getOrderUuid());
        // create a concept for MAR

        Reference openmrsForReference = new Reference();
        openmrsForReference.setType(Patient.class.getTypeName());
        openmrsForReference.setTargetUuid(scheduleMedicationRequest.getPatientUuid());
        openmrsForReference.setName(openmrsForReference.getType() + "/" + openmrsForReference.getReference());

        Reference openmrsByReference = new Reference();
        openmrsByReference.setType(Patient.class.getTypeName());
        openmrsByReference.setTargetUuid(scheduleMedicationRequest.getProviderUuid());
        openmrsByReference.setName(openmrsByReference.getType() + "/" + openmrsByReference.getReference());

        schedule.setForReference(openmrsForReference);
        schedule.setByReference(openmrsByReference);
        schedule.setStartDate(order.getEffectiveStartDate());
        schedule.setEndDate(order.getEffectiveStopDate());
        schedule.setActive(true);

        return schedule;
    }
}
