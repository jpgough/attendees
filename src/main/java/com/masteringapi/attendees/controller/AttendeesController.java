package com.masteringapi.attendees.controller;

import com.masteringapi.attendees.model.Attendee;
import com.masteringapi.attendees.model.AttendeeResponse;
import com.masteringapi.attendees.service.AttendeeStore;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<AttendeeResponse> getAttendees() {
        CacheControl cacheControl = CacheControl.noCache();
        cacheControl.noStore();
        cacheControl.mustRevalidate();
        cacheControl.proxyRevalidate();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CACHE_CONTROL, cacheControl.getHeaderValue());

        return ResponseEntity.ok().headers(headers).body(new AttendeeResponse(store.getAttendees()));
    }

    @GetMapping("/attendees/{id}")
    @ResponseBody
    public Attendee getAttendee(@PathVariable Integer id) {
        return store.getAttendees().get(id);
    }

    @GetMapping("/external")
    @ResponseBody
    public String getExternalContent() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Host", "httpbin.org");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("http://52.55.211.119/get", HttpMethod.GET,
                requestEntity, String.class);
        return response.toString();
    }


}
