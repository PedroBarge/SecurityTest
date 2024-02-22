package com.security.teste.controller;

import com.security.teste.dto.SecureDto;
import com.security.teste.service.SecureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secure")
public class SecureController {
    private final SecureService service;

    public SecureController(SecureService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<SecureDto> get() {
        return service.getSecureDto();
    }

    @PostMapping("/add")
    public void doLogin(@RequestBody SecureDto dto) {
        service.doLogin(dto);
    }
}
