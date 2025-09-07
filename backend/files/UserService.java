package com.tms.service;

import com.tms.dto.UserDTO;
import com.tms.dto.request.LoginRequest;
import com.tms.dto.request.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> login(LoginRequest loginRequest);

    UserDTO register(RegisterRequest registerRequest);
}