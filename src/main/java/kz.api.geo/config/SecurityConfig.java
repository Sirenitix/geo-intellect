package kz.api.geo.config;

import kz.api.geo.jwt.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.security.SecureRandom;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    private static final String SECRET = "geo_intellect_!@#";

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SECRET.getBytes()));
    }

    @Bean
    public AuthenticationProvider authenticationProvider(BCryptPasswordEncoder bCryptPasswordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }


    @Bean
    protected SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors()
                .and()
                .logout().logoutUrl("/logout").deleteCookies("token")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/auth/register").permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/auth/generate-token").permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/auth/password").permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/layers/list").permitAll()
                .and()
                .addFilterBefore(new CustomAuthorizationFilter(),
                        UsernamePasswordAuthenticationFilter.class);

        http.headers().cacheControl();

        http.authorizeRequests()
                .antMatchers("/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**")
                .permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();

        return http.build();
    }
}