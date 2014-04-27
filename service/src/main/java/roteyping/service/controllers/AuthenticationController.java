package roteyping.service.controllers;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import roteyping.service.model.AuthenticateRequest;
import roteyping.service.repositories.AuthenticationRepository;

@Controller
public class AuthenticationController {

    private AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationController(AuthenticationRepository authenticationRepository){
        this.authenticationRepository = authenticationRepository;
    }
    @RequestMapping(value="/authenticate", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Boolean> authenticateRequest(@RequestBody AuthenticateRequest request) {
        if(Strings.isNullOrEmpty(request.getEmailAddress()) || Strings.isNullOrEmpty(request.getPassword())){
            return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
        }
        if(authenticationRepository.exists(request.getEmailAddress(), request.getPassword())){
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.OK);
    }
}
