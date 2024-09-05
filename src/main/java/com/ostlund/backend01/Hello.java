package com.ostlund.backend01;

import org.springframework.stereotype.Component;

@Component
public class Hello implements HelloInterface{

    @Override
    public String hello() {
        return "Hello World!? :P";
    }
}
