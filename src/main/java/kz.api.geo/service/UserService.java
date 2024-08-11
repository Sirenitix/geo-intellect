package kz.api.geo.service;

import kz.api.geo.dto.UserPasswordDto;
import kz.api.geo.entity.User;

import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findByUsername(String username);

    void changePassword(UserPasswordDto userPasswordDto);
}
