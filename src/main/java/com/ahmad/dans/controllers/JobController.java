package com.ahmad.dans.controllers;

import com.ahmad.dans.payload.response.JobResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/job")
public class JobController {

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    private static ResponseEntity<List<JobResponse>> getJobList(){
        final String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<JobResponse>> responseEntity =
                restTemplate.exchange(uri,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<JobResponse>>() {
                        });
        List<JobResponse> jobList = responseEntity.getBody();
        return ResponseEntity.ok(jobList);
    }

    @GetMapping("/detail/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    private static ResponseEntity<JobResponse> getJobDetail(@PathVariable String id){
        final String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions/"+id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JobResponse>  responseEntity =
                restTemplate.exchange(uri,
                        HttpMethod.GET, null, new ParameterizedTypeReference<JobResponse>() {
                        });
        JobResponse jobList = responseEntity.getBody();
        return ResponseEntity.ok(jobList);
    }

}
