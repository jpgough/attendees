package com.masteringapi.attendees.controller;

import com.masteringapi.attendees.model.AttendeeResponse;
import com.masteringapi.attendees.service.AttendeeStore;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AttendeesController {

    @Autowired
    private AttendeeStore store;

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/attendees")
    @ResponseBody
    @ApiOperation(value = "Retrieve a list of all attendees stored within the system", nickname = "getAttendees")
    public AttendeeResponse getAttendees() {
        return new AttendeeResponse(store.getAttendees());
    }

    @GetMapping("/external")
    @ResponseBody
    public String getExternalContent() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://52.55.211.119/get", String.class);
        return entity.toString();
    }


}
