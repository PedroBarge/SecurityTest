package com.security.teste.controller;

import com.security.teste.dto.SecureDto;
import com.security.teste.service.SecureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecureController {
    private final SecureService service;

    public SecureController(SecureService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public String get() {
        return "ola";
    }

    @PostMapping("/add")
    public void doLogin(@RequestBody SecureDto dto) {
        service.doLogin(dto);
    }
}
