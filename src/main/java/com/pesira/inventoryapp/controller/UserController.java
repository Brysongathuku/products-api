package com.pesira.inventoryapp.controller;

import com.pesira.inventoryapp.dto.PageResponse;
import com.pesira.inventoryapp.dto.UserRequest;
import com.pesira.inventoryapp.dto.UserResponse;
import com.pesira.inventoryapp.model.AccountStatus;
import com.pesira.inventoryapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// All endpoints here are ADMIN-only, enforced globally in SecurityConfig ("/api/users/**")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<PageResponse<UserResponse>> list(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(userService.list(search, page, size));
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @Valid @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.update(id, request));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<UserResponse> setStatus(@PathVariable Long id, @RequestParam AccountStatus status) {
        return ResponseEntity.ok(userService.setStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
