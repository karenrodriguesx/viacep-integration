package com.viacep.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
* Projeto de integração com a ViaCep API utilizando design patterns
*
* @author karenrodrigues
* */

@EnableFeignClients
@SpringBootApplication
public class ViacepIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViacepIntegrationApplication.class, args);
    }

}
