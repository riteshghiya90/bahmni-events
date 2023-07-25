package org.bahmni.module.events.ipd.contract;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bahmni.module.events.ipd.model.Schedule;
import org.openmrs.Concept;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@AllArgsConstructor
@NoArgsConstructor
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
