package kz.api.geo.dto;

public record UserPasswordDto(
        String username,
        String oldPassword,
        String newPassword
) {
}
