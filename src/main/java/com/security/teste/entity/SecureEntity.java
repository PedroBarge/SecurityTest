package com.security.teste.entity;

import com.security.teste.roleenum.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "testsecurity")
public class SecureEntity {
    @Id
    private int id;
    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}
