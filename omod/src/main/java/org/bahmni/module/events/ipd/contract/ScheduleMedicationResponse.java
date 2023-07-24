package org.bahmni.module.events.ipd.contract;

import lombok.Builder;
import lombok.Getter;
import org.bahmni.module.events.ipd.model.Schedule;
import org.openmrs.Concept;

import java.util.Date;

@Getter
@Builder
public class ScheduleMedicationResponse {
    private Integer id;
    private String patientUuid;
    private String comments;
    private Date startDate;
    private Date endDate;
    private Concept scheduleServiceType;

    public static ScheduleMedicationResponse constructFrom(Schedule schedule) {
        return ScheduleMedicationResponse.builder()
            .id(schedule.getId())
            .patientUuid(schedule.getForReference().getUuid())
            .comments(schedule.getComments())
            .startDate(schedule.getStartDate())
            .endDate(schedule.getEndDate())
            .scheduleServiceType(schedule.getServiceType())
            .build();
    }
}

/**
 * private List<MedicationSlot> medicationSlotList;
 */
