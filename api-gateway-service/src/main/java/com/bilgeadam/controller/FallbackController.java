package com.bilgeadam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @GetMapping("/authservice")
    public ResponseEntity<String>authServiceFallback(){
        return ResponseEntity.ok("Auth service su an da hizmet disidir...");
    }

    @GetMapping("/userservice")
    public ResponseEntity<String>userServiceFallback(){
        return ResponseEntity.ok("User service su an da hizmet disidir...");
    }
}
