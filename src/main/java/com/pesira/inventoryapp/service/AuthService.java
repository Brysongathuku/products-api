package com.pesira.inventoryapp.service;

import com.pesira.inventoryapp.dto.AuthResponse;
import com.pesira.inventoryapp.dto.LoginRequest;
import com.pesira.inventoryapp.exception.BadRequestException;
import com.pesira.inventoryapp.model.User;
import com.pesira.inventoryapp.repository.UserRepository;
import com.pesira.inventoryapp.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        String token = jwtService.generateToken(user);
        return new AuthResponse(token, user.getUsername(), user.getFullName(), user.getRole().name());
    }
}
