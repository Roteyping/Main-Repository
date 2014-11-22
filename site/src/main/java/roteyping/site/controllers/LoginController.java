package roteyping.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import roteyping.site.config.SiteConfig;
import roteyping.site.model.LoginRequest;

@Controller
public class LoginController {
    private static final String LOGIN_URL = "authenticate";

    private RestTemplate restTemplate;
    private SiteConfig siteConfig;

    @Autowired
    public LoginController(RestTemplate restTemplate, SiteConfig siteConfig) {
        this.restTemplate = restTemplate;
        this.siteConfig = siteConfig;
    }

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value="/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Boolean> postForlogin(@RequestBody LoginRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LoginRequest> requestHttpEntity = new HttpEntity<>(request, headers);

        return restTemplate.postForEntity(siteConfig.serviceUrl() + LOGIN_URL, requestHttpEntity, Boolean.class);
    }

}
