/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dans.test.recruitment.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserLoginDTO {
    private String message;
    private Date login_date;
    private String token;
    
    public ResponseUserLoginDTO success(String token) {
        return new ResponseUserLoginDTO("Login sukses.", new Date(), token);
    }
    
    public ResponseUserLoginDTO denied() {
        return new ResponseUserLoginDTO("User tidak dikenal.", null, null);
    }
    
    public ResponseUserLoginDTO fail() {
        return new ResponseUserLoginDTO("Terjadi kesalahan. Login gagal.", null, null);
    }
    
    
}
