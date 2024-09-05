package com.ostlund.backend01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Backend01Application {

  public static void main(String[] args) {
    ApplicationContext applicationContext =
    SpringApplication.run(Backend01Application.class, args);
    HelloInterface helloInterface = applicationContext.getBean(Hello.class, args);
    System.out.println(helloInterface.hello());
  }
}
