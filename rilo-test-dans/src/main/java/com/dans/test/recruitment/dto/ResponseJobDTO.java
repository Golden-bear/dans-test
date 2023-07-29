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
public class ResponseJobDTO {
    private ResponseDTO response;
    private JobDTO data;
}
