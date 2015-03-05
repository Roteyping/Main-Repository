package myhh.site.controllers;

import myhh.site.config.SiteConfig;
import myhh.site.model.SignUpRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sadhikari on 3/3/15.
 */
@Controller
public class SignUpController {
    private static final String SIGNUP_URL = "addNewUser";

    private RestTemplate restTemplate;
    private SiteConfig siteConfig;

    @RequestMapping(value="/signup", method= RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("signup");
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<Boolean> postSignUp(String email, String password, String firstname, String lastname) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        SignUpRequest request = new SignUpRequest();
        request.setEmail(email);
        request.setPassword(password);
        request.setFirstName(firstname);
        request.setLastName(lastname);

        HttpEntity<SignUpRequest> requestHttpEntity = new HttpEntity<SignUpRequest>(request, headers);
        return restTemplate.postForEntity(siteConfig.serviceUrl() + SIGNUP_URL, requestHttpEntity, Boolean.class);
    }

}
