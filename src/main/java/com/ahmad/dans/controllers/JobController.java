package com.ahmad.dans.controllers;

import com.ahmad.dans.payload.response.JobResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotBlank;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/job")
public class JobController {

    @GetMapping("/list")
    @PreAuthorize("hasLogin('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    private static ResponseEntity<List<JobResponse>> getJobList(){
        final String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<List<JobResponse>> responseEntity =
                    restTemplate.exchange(uri,
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<JobResponse>>() {
                            });
            List<JobResponse> jobList = responseEntity.getBody();
            return ResponseEntity.ok(jobList);
        } catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
            return ResponseEntity.status(httpClientOrServerExc.getStatusCode()).body(null);
        }
    }

    @GetMapping("/detail/{id}")
    @Validated
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    private static ResponseEntity<JobResponse> getJobDetail(@PathVariable @NotBlank(message = "InvalidID") String id){
        final String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions/"+id;
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<JobResponse>  responseEntity =
                    restTemplate.exchange(uri,
                            HttpMethod.GET, null, new ParameterizedTypeReference<JobResponse>() {
                            });
            JobResponse jobList = responseEntity.getBody();
            assert jobList != null;
            if (jobList.getId()==null){
                jobList.setDescription("Id Not Found");
            }
            return ResponseEntity.ok(jobList);
        } catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
            return ResponseEntity.status(httpClientOrServerExc.getStatusCode()).body(null);
        }
    }

}
