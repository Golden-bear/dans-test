/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dans.test.recruitment.service;


import com.dans.test.recruitment.domain.UserLogin;
import com.dans.test.recruitment.dto.RequestUserLoginDTO;
import com.dans.test.recruitment.dto.ResponseUserLoginDTO;
import com.dans.test.recruitment.repository.UserLoginRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    
    @Autowired
    UserLoginRepository userRepository;
    
    public ResponseEntity<ResponseUserLoginDTO> login(RequestUserLoginDTO req) {
        ResponseUserLoginDTO res = new ResponseUserLoginDTO().denied();
        try {
            int shift = 3;
            String pwdEncrypt = encrypt(req.getPassword(), shift);
            System.out.println("pwd : " +pwdEncrypt);
            UserLogin userLogin = userRepository.getUserLogin(req.getUsername(), pwdEncrypt);
            if(userLogin != null) {
                String token = generateToken();
                res = new ResponseUserLoginDTO().success(token);
            }
        } catch (Exception e) {
            res = new ResponseUserLoginDTO().fail();
        }
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    
    
    public static String encrypt(String plainText, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + shift) % 26 + base);
            }
            encryptedText.append(ch);
        }
        return encryptedText.toString();
    }
    
    
     private String generateToken() {
            long EXPIRATION_TIME = 864_000_000;
            return Jwts.builder()
                .setSubject("user")
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, "testing")
                .compact();
    }
          
}
