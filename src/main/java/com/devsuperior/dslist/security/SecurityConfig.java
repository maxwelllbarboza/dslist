package com.devsuperior.dslist.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 🔹 Desativa CSRF para testes com POST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // 🔹 Libera todas as rotas
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form.disable()) // 🔹 Desativa login por formulário
                .httpBasic(httpBasic -> httpBasic.disable()); // 🔹 Desativa autenticação básica

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
