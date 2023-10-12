//package com.twitter.Config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//@Configuration
//@EnableWebSecurity
//public class AppConfig {
//
//    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
//        http.csrf((Customizer<CsrfConfigurer<HttpSecurity>>) corsConfigrationSource()).authorizeHttpRequests()
//        http.cors().and().csrf().disable().authorizeHttpRequests(Authorize-> Authorize.requestMatchers("/api/**").authenticated()
//                .anyRequest().permitAll())
//                .addFilterBefore(null, BasicAuthenticationFilter.class)
//
//                .httpBasic().and().formLogin();
//        return http.build();
//    }
//
//    private CorsConfigurationSource corsConfigrationSource() {
//        return new CorsConfigurationSource() {
//            @Override
//            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//                CorsConfiguration cfg = new CorsConfiguration();
//                cfg.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
//                cfg.setAllowedMethods(Collections.singletonList("*"));
//                cfg.setAllowCredentials(true);
//                cfg.setAllowedHeaders(Collections.singletonList("*"));
//                cfg.setExposedHeaders(Arrays.asList("Authorization"));
//                cfg.setMaxAge(3600L);
//                return cfg;
//            }
//        };
//    }
//
//}
