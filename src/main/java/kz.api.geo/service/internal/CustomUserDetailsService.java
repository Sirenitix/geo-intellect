package kz.api.geo.service.internal;


import kz.api.geo.entity.User;
import kz.api.geo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    final private UserRepository userRepository;

    private static final String USER_NOT_FOUND_MESSAGE = "User with username %s not found";

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            String message = String.format(USER_NOT_FOUND_MESSAGE, username);
            log.error(message);
            throw new UsernameNotFoundException(message);
        } else {
            log.debug("User found in the database: {}", username);
            return new User(
                    user.get().getId(),
                    user.get().getUsername(),
                    user.get().getPassword(),
                    user.get().isEnabled(),
                    user.get().getRole()
            );
        }
    }
}