/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dans.test.recruitment.repository;


import com.dans.test.recruitment.domain.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, String>{
    
    @Query("Select u From UserLogin u Where u.username = ?1 And u.password = ?2 ")
    UserLogin getUserLogin(String username, String password);
    
}
