package myhh.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import myhh.service.repositories.AuthenticationRepository;
import myhh.service.repositories.LocalAuthenticationRepository;

@Configuration
@EnableWebMvc
@ComponentScan("myhh.service")
public class ServiceSpringMVCConfig {
    @Bean
    public AuthenticationRepository authenticationRepository(){
        return new LocalAuthenticationRepository();
    }

}
