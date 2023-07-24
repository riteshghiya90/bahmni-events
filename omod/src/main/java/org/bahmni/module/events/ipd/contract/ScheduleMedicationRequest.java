package org.bahmni.module.events.ipd.contract;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class ScheduleMedicationRequest {

    private String patientUuid;
    private String orderUuid;
    private String providerUuid;
    private String comments;
    private List<Date> firstDaySlots;
    private List<Date> subsequentDaySlots;
}
