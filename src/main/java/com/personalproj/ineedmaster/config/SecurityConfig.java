package com.personalproj.ineedmaster.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/api/counties").permitAll()
                                .requestMatchers("/api/categories").permitAll()
                                .requestMatchers("/api/users/master/{id}").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/solutions/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/solutions").hasRole("MASTER")
                                .requestMatchers(HttpMethod.PUT, "/api/solutions/{id}").hasRole("MASTER")
                                .requestMatchers("/api/solutions/county/**").permitAll()
                                .requestMatchers("/api/solutions/master/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/tasks").hasRole("CUSTOMER")
                                .requestMatchers(HttpMethod.PUT, "/api/tasks/{id}/customer").hasRole("CUSTOMER")
                                .requestMatchers(HttpMethod.GET, "/api/tasks/customer/**").hasRole("CUSTOMER")
                                .requestMatchers(HttpMethod.PUT, "/api/tasks/{id}/master").hasRole("MASTER")
                                .requestMatchers(HttpMethod.GET, "/api/tasks/master/**").hasRole("MASTER")
                                .requestMatchers("/api/demo-controller/hello/customer").hasRole("CUSTOMER")
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
    }
}
