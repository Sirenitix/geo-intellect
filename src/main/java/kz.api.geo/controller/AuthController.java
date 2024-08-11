package kz.api.geo.controller;


import io.swagger.v3.oas.annotations.Operation;
import kz.api.geo.dto.UserAuthDto;
import kz.api.geo.dto.UserPasswordDto;
import kz.api.geo.entity.User;
import kz.api.geo.exceptions.UserAlreadyExistException;
import kz.api.geo.jwt.JwtUtil;
import kz.api.geo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    final private UserService userService;
    final private AuthenticationManager authenticationManager;

    @Operation(summary = "Welcome")
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Geo Intellect Api";
    }

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Registration")
    @CrossOrigin(origins = "http://localhost:3000")
    public String save(@RequestBody UserAuthDto userDto) {
        userService.findByUsername(userDto.username()).ifPresent(
                user -> {
                    throw new UserAlreadyExistException(
                            "Username already exist: " + user.getUsername()
                    );
                }
        );
        User userEntity = userService.save(userDto.toEntity());
        return "User created successfully: " + userEntity.getUsername();
    }

    @Operation(summary = "Password renewal")
    @PostMapping("password")
    public String changePassword(@RequestBody UserPasswordDto passwordDto) {
        userService.changePassword(passwordDto);
        return "Password changed successfully";
    }

    @Operation(summary = "Get token")
    @PostMapping("generate-token")
    @CrossOrigin(origins = "http://localhost:3000")
    public String authenticateUser(@Valid @RequestBody UserAuthDto userDto, HttpServletRequest request) {
        var user = userService.findByUsername(userDto.username())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.username(),
                userDto.password()
        ));

        return JwtUtil.createAccessToken(
                user.getUsername(),
                request.getRequestURL().toString(),
                user.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList())
        );
    }
}
