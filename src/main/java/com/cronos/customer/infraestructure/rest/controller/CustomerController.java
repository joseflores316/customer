package com.cronos.customer.infraestructure.rest.controller;

import com.cronos.customer.application.service.CustomerService;
import com.cronos.customer.domain.models.CustomerDto;
import com.cronos.customer.infraestructure.config.Routes;
import com.cronos.customer.infraestructure.config.security.model.AuthenticationReq;
import com.cronos.customer.infraestructure.config.security.model.TokenInfo;
import com.cronos.customer.infraestructure.config.security.service.JwtUtilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Customer API", description = "The Customer API")
@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private AuthenticationManager authenticationManager;


    private final CustomerService customerService;

    @Autowired
    UserDetailsService usuarioDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @Operation(description = "Get all customers", summary = "Get all customers")
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping(Routes.PATH_ID)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.findById(id),HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.create(customerDto), HttpStatus.CREATED);
    }

    @PutMapping(value = Routes.PATH_ID, consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id,@Valid @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.update(id, customerDto), HttpStatus.OK);
    }

    @DeleteMapping(value = Routes.PATH_ID)
    public void deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteById(id);
    }

    @PostMapping(value = Routes.ENTITY_ROOT + Routes.ENTITY_ID_PATH + Routes.INSTANCE_ROOT + Routes.INSTANCE_ID_PATH + Routes.SUB_INSTANCE_ROOT + Routes.SUB_INSTANCE_ID_PATH + Routes.FILE_ROOT + Routes.FILE_ID_PATH)
    public ResponseEntity<List<CustomerDto>> testCustomer(@PathVariable Long entityId, @PathVariable Long instanceId, @PathVariable Long subinstanceId, @PathVariable Long fileId) {

        Long entityId1 = entityId;
        Long instanceId1 = instanceId;
        Long subInstanceId1 = subinstanceId;
        Long fileId1 = fileId;



        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/mensaje")
    public ResponseEntity<?> getMensaje() {
        log.info("Obteniendo el mensaje");

        var auth =  SecurityContextHolder.getContext().getAuthentication();
        log.info("Datos del Usuario: {}", auth.getPrincipal());
        log.info("Datos de los Roles {}", auth.getAuthorities());
        log.info("Esta autenticado {}", auth.isAuthenticated());

        Map<String, String> mensaje = new HashMap<>();
        mensaje.put("contenido", "Hola Peru");
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> getMensajeAdmin() {

        var auth =  SecurityContextHolder.getContext().getAuthentication();
        log.info("Datos del Usuario: {}", auth.getPrincipal());
        log.info("Datos de los Permisos {}", auth.getAuthorities());
        log.info("Esta autenticado {}", auth.isAuthenticated());

        Map<String, String> mensaje = new HashMap<>();
        mensaje.put("contenido", "Hola Admin");
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/publico")
    public ResponseEntity<?> getMensajePublico() {
        var auth =  SecurityContextHolder.getContext().getAuthentication();
        log.info("Datos del Usuario: {}", auth.getPrincipal());
        log.info("Datos de los Permisos {}", auth.getAuthorities());
        log.info("Esta autenticado {}", auth.isAuthenticated());

        Map<String, String> mensaje = new HashMap<>();
        mensaje.put("contenido", "Hola. esto es publico");
        return ResponseEntity.ok(mensaje);
    }


    @PostMapping("/publico/authenticate")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthenticationReq authenticationReq) {
        log.info("Autenticando al usuario {}", authenticationReq.getUsuario());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationReq.getUsuario(),
                        authenticationReq.getClave()));

        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
                authenticationReq.getUsuario());

        final String jwt = jwtUtilService.generateToken(userDetails);

        return ResponseEntity.ok(new TokenInfo(jwt));
    }




}
