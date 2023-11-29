package com.project.spring.monthlyexpensestracker.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean isValid(String name,String password){
        return name.equals("venugopal") && password.equals("vg@123");
    }
}
