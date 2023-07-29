/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dans.test.recruitment.service;

import com.dans.test.recruitment.dto.JobDTO;
import com.dans.test.recruitment.dto.ResponseDTO;
import com.dans.test.recruitment.dto.ResponseJobDTO;
import com.dans.test.recruitment.dto.ResponseJobListDTO;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobListService {

    @Value("${api.job.list}")
    private String JOB_LIST_API;

    @Value("${api.job.detail}")
    private String JOB_DETAIL_API;

    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<ResponseJobListDTO> getJobs() {
        List<JobDTO> list = new ArrayList<>();
        ResponseEntity<ResponseJobListDTO> resPayload;
        try {
            String res = restTemplate.getForObject(
                        JOB_LIST_API, 
                        String.class);
            JobDTO[] jobs = new Gson().fromJson(res, JobDTO[].class);
            list = Arrays.asList(jobs);
            resPayload = ResponseEntity.status(HttpStatus.FOUND).body(new ResponseJobListDTO(new ResponseDTO().defaultResponse(), list));
        } catch (Exception e) {
            resPayload = ResponseEntity.status(HttpStatus.FOUND).body(new ResponseJobListDTO(new ResponseDTO().failedRespose(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage()), new ArrayList<>()));
        }
        return resPayload;
    }

    public ResponseEntity<ResponseJobDTO> getJobDetail(String id) {
        JobDTO data = new JobDTO();
        ResponseEntity<ResponseJobDTO> resPayload = null;
        try {
            if(id != null) {
                String res = restTemplate.getForObject(
                        JOB_DETAIL_API, 
                        String.class, id);
                data = new Gson().fromJson(res, JobDTO.class);
                resPayload = ResponseEntity.status(HttpStatus.FOUND).body(new ResponseJobDTO(new ResponseDTO().defaultResponse(), data));
            }
        } catch (Exception e) {
            resPayload = ResponseEntity.status(HttpStatus.FOUND).body(new ResponseJobDTO(new ResponseDTO().failedRespose(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage()), null));
        }
        return resPayload;
    }
    
}
