package myhh.service.controllers;

import com.google.common.base.Strings;
import myhh.service.model.AuthenticateRequest;
import myhh.service.repositories.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sadhikari on 3/3/15.
 */
public class UserController {
    private AuthenticationRepository authenticationRepository;

    @Autowired
    public UserController(AuthenticationRepository authenticationRepository){
        this.authenticationRepository = authenticationRepository;
    }

    @RequestMapping(value="/authenticate", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Boolean> authenticateRequest(@RequestBody AuthenticateRequest request) {
        if(Strings.isNullOrEmpty(request.getEmail()) || Strings.isNullOrEmpty(request.getPassword())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(authenticationRepository.exists(request.getEmail(), request.getPassword())){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
