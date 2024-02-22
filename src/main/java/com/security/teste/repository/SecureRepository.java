package com.security.teste.repository;

import com.security.teste.entity.SecureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureRepository extends JpaRepository<SecureEntity, Integer> {
}
