package edu.icet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component //class handover to spring
public class BeanConfig {
    @Bean //method call and crate object in IOC container
   RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
