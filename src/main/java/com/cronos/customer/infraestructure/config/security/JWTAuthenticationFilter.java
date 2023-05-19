package com.cronos.customer.infraestructure.config.security;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
}
