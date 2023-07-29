/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dans.test.recruitment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author user
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private String status;
    private String code;
    
    public ResponseDTO defaultResponse() {
        ResponseDTO response = new ResponseDTO();
        response.setStatus("01");
        response.setCode("201");
        response.setMessage("Process Successed");
        return response;
    }
    
    public ResponseDTO failedRespose(String code, String message) {
        ResponseDTO response = new ResponseDTO();
        response.setStatus("0");
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
    
    public ResponseDTO noDataFoundResponse() {
        ResponseDTO response = new ResponseDTO();
        response.setStatus("0");
        response.setCode("204");
        response.setMessage("No data Found");
        return response;
    }
}
