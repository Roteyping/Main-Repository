package myhh.service.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import myhh.service.model.AuthenticateRequest;
import myhh.service.repositories.AuthenticationRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationControllerTest {
    @Mock
    AuthenticationRepository repository;

    @Test
    public void should_authenticate_request_for_valid_credentials(){
        when(repository.exists("test@test.com", "password")).thenReturn(true);
        AuthenticationController controller = new AuthenticationController(repository);
        ResponseEntity<Boolean> response = controller.authenticateRequest(buildRequest("test@test.com", "password"));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), true);
    }

    @Test
    public void should_not_authenticate_request_for_invalid_credentials(){
        when(repository.exists("test@test.com", "password")).thenReturn(false);
        AuthenticationController controller = new AuthenticationController(repository);
        ResponseEntity<Boolean> response = controller.authenticateRequest(buildRequest("test@test.com", "password"));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), false);
    }

    @Test
    public void should_send_bad_request_when_email_is_empty(){
        AuthenticationController controller = new AuthenticationController(repository);
        ResponseEntity<Boolean> response = controller.authenticateRequest(buildRequest("", "password"));
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void should_send_bad_request_when_password_is_empty(){
        AuthenticationController controller = new AuthenticationController(repository);
        ResponseEntity<Boolean> response = controller.authenticateRequest(buildRequest("test@test.com", ""));
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    private AuthenticateRequest buildRequest(String email, String password){
        AuthenticateRequest authenticateRequest = new AuthenticateRequest();
        authenticateRequest.setEmail(email);
        authenticateRequest.setPassword(password);
        return authenticateRequest;
    }
}
