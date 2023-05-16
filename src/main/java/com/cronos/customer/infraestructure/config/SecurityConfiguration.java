package com.cronos.customer.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.time.Duration;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private static final String[] NO_AUTH_LIST = {
        "/v3/api-docs/",
        "/configuration/ui",
        "/swagger-resources",
        "/configuration/security",
        "/webjars/**",
        "/login",
        "/h2-console/**"};



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        http.csrf().disable().authorizeHttpRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic(withDefaults())
//                .formLogin(withDefaults());
//
//        return http.build();


        http.csrf().disable()
                .authorizeHttpRequests((authz) -> authz
                .antMatchers(NO_AUTH_LIST).permitAll()
                .antMatchers(HttpMethod.POST, "/api/customer/**").authenticated()
                .antMatchers(HttpMethod.GET, "/api/customer/**").hasRole("ADMIN")
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults());


        return http.build();

    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cc = new CorsConfiguration();

        cc.setAllowedHeaders(Arrays.asList("Origin,Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization"));
        cc.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));

        cc.setAllowedOrigins(Arrays.asList("/*")); //Hay que especificar el origen especifico(dominio, subdominio) de los clientes que haran uso de la aplicacion back

        cc.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT", "PATCH"));

        cc.addAllowedOriginPattern("*");


        cc.setMaxAge(Duration.ZERO);
        cc.setAllowCredentials(Boolean.TRUE);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cc);
        return source;
    }



}
