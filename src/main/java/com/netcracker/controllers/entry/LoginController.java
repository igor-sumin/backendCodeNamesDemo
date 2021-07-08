package com.netcracker.controllers.entry;

import com.netcracker.dto.LoginRequestDTO;
import com.netcracker.services.entry.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO: realize ResponseExceptionHandler

@RestController
@RequestMapping("login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequestDTO loginDTO) {


        // TODO: вынеси куда-нибудь
        if (loginService.isEmpty(loginDTO)) {
            return new ResponseEntity<>(
                    "error: login or password is empty",
                    HttpStatus.BAD_REQUEST
            );
        }

        String token = loginService.login(loginDTO).getToken();

        System.out.println("data = " + loginDTO.getLogin() + ", " + loginDTO.getPassword());

        return ResponseEntity.ok(token);
    }
}