package org.bahmni.module.events.ipd.controller;

import org.bahmni.module.events.ipd.contract.ScheduleMedicationRequest;
import org.bahmni.module.events.ipd.contract.ScheduleMedicationResponse;
import org.bahmni.module.events.ipd.model.Schedule;
import org.bahmni.module.events.ipd.service.ScheduleMedicationService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/ipd/schedule/medication")
public class ScheduleMedicationController extends BaseRestController {

    private final ScheduleMedicationService scheduleMedicationService;

    @Autowired
    public ScheduleMedicationController(ScheduleMedicationService scheduleMedicationService) {
        this.scheduleMedicationService = scheduleMedicationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ScheduleMedicationResponse createMedicationSchedule(@RequestBody ScheduleMedicationRequest scheduleMedicationRequest) {
        Schedule schedule = scheduleMedicationService.schedule(scheduleMedicationRequest);
        return ScheduleMedicationResponse.constructFrom(schedule);
    }
}
