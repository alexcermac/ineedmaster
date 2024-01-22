package com.personalproj.ineedmaster.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // first we disable CSRF
                .csrf()
                .disable()
//                .csrf(csrf -> csrf.disable())
                // Now we implement the configuration
                .authorizeHttpRequests()
                // WhiteList of URLs
                .requestMatchers("/api/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/token/**").permitAll()
//                        .anyRequest().authenticated()
//                )
                .and()
                .sessionManagement()
//                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // tell spring which authentication provider
                .authenticationProvider(authenticationProvider)
                // We want to use this filter before username password authentication filter
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
