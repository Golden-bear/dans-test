/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dans.test.recruitment.rest;


import com.dans.test.recruitment.dto.RequestUserLoginDTO;
import com.dans.test.recruitment.dto.ResponseUserLoginDTO;
import com.dans.test.recruitment.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginRestController {
    
    @Autowired
    UserLoginService loginService;
    
    @RequestMapping(value = "/api/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUserLoginDTO> postLogin(@RequestBody RequestUserLoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
