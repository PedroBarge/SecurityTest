package com.security.teste.service;

import com.security.teste.dto.SecureDto;
import com.security.teste.entity.SecureEntity;
import com.security.teste.repository.SecureRepository;
import com.security.teste.roleenum.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SecureService {

    private final SecureRepository repository;

    public List<SecureDto> getSecureDto() {
        return repository.findAll().stream()
                .map(userEntity -> new SecureDto(userEntity.getName()))
                .toList();
    }

    public void doLogin(SecureDto secureDto) {
        SecureEntity secureEntity = new SecureEntity();
        secureEntity.setName(secureDto.getName());
        secureEntity.setRole(RoleEnum.USER);
        repository.save(secureEntity);
    }
}
