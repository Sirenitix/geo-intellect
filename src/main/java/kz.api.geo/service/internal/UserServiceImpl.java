package kz.api.geo.service.internal;

import kz.api.geo.dto.UserPasswordDto;
import kz.api.geo.entity.User;
import kz.api.geo.repo.UserRepository;
import kz.api.geo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;

    final private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        log.info("Saving user {} to the database", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void changePassword(UserPasswordDto userPasswordDto) {
        var user = userRepository.findByUsername(userPasswordDto.username())
                .orElseThrow(
                        () -> new UsernameNotFoundException("Username nor found")
                );

        if (!passwordEncoder.matches(userPasswordDto.oldPassword(), user.getPassword())) {
            throw new BadCredentialsException("Wrong password");
        }

        String encryptedPassword = passwordEncoder.encode(userPasswordDto.newPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }
}
