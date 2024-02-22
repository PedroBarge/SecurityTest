package com.security.teste.roleenum;

public enum RoleEnum {
    USER("User"),
    ADMIN("Admin");
    private String role;
    RoleEnum(String role) {
        this.role = role;
    }

}
