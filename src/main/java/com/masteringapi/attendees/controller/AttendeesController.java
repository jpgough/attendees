package com.masteringapi.attendees.controller;

import com.masteringapi.attendees.model.Attendee;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AttendeesController {

    @GetMapping("/attendees")
    @ResponseBody
    @ApiOperation(value = "Retrieve a list of all attendees stored within the system", nickname = "getAttendees")
    public List<Attendee> getAttendees() {
        return new ArrayList<>();
    }

}
