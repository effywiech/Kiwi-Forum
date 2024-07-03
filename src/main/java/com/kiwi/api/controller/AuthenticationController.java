package com.kiwi.api.controller;

import com.kiwi.api.security.JWTTokenData;
import com.kiwi.api.security.TokenService;
import com.kiwi.api.user.DataUserAuthentication;
import com.kiwi.api.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid DataUserAuthentication dataUserAuthentication) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
                dataUserAuthentication.getLogin(),
                dataUserAuthentication.getPassword()
        );
        var authenticatedUser = authenticationManager.authenticate(authenticationToken);
        var JWTtoken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new JWTTokenData(JWTtoken));
    }
}
