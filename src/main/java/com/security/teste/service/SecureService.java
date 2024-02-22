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
                .sorted(Comparator.comparing(SecureEntity::getId))
                .map(userEntity -> new SecureDto(userEntity.getName()))
                .toList();
    }

    public void doLogin(SecureDto secureDto) {
        SecureEntity secureEntity = new SecureEntity();
        secureEntity.setName(secureDto.getName());
        secureEntity.setRole(RoleEnum.USER);
        SecureEntity secureEntity1 = new SecureEntity();
        secureEntity1.setName(secureDto.getName());
        secureEntity1.setRole(RoleEnum.ADMIN);
        repository.save(secureEntity);
        repository.save(secureEntity1);
    }
}
