package kz.api.geo.dto;

import kz.api.geo.entity.User;

public record UserAuthDto(String username, String password) {
    public User toEntity() {
        return User.builder()
                .username(this.username)
                .password(this.password)
                .enabled(true)
                .role("ROLE_USER")
                .build();
    }
}
