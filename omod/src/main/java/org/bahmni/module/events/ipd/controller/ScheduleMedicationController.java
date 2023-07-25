package org.bahmni.module.events.ipd.controller;

import lombok.extern.slf4j.Slf4j;
import org.bahmni.module.events.ipd.contract.ScheduleMedicationRequest;
import org.bahmni.module.events.ipd.contract.ScheduleMedicationResponse;
import org.bahmni.module.events.ipd.model.Schedule;
import org.bahmni.module.events.ipd.service.ScheduleMedicationService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.RestUtil;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/ipd/schedule/medication")
@Slf4j
public class ScheduleMedicationController extends BaseRestController {

    private final ScheduleMedicationService scheduleMedicationService;

    @Autowired
    public ScheduleMedicationController(ScheduleMedicationService scheduleMedicationService) {
        this.scheduleMedicationService = scheduleMedicationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> createMedicationSchedule(@Valid @RequestBody ScheduleMedicationRequest scheduleMedicationRequest) {
        try {
            Schedule schedule = scheduleMedicationService.schedule(scheduleMedicationRequest);
            return new ResponseEntity<>(ScheduleMedicationResponse.constructFrom(schedule), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Runtime error while trying to create new appointment", e);
            return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
