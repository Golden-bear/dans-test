/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dans.test.recruitment.rest;


import com.dans.test.recruitment.dto.ResponseJobDTO;
import com.dans.test.recruitment.dto.ResponseJobListDTO;
import com.dans.test.recruitment.service.JobListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobLIstController {
    
    @Autowired
    JobListService service;
    
    @RequestMapping(value = "/api/get.job.list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseJobListDTO> getJobList() {
        return service.getJobs();
    }
    
    @RequestMapping(value = "/api/get.job.detail/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseJobDTO> getJobDetail(@PathVariable("id") String id) {
        return service.getJobDetail(id);
    }
   
}
