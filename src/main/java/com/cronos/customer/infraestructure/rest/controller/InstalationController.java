package com.cronos.customer.infraestructure.rest.controller;

import com.cronos.customer.application.service.InstalationService;
import com.cronos.customer.domain.models.InstalationDto;
import com.cronos.customer.domain.models.InstalationDtoPK;
import com.cronos.customer.infraestructure.config.Routes;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instalation")
@Slf4j
public class InstalationController {

    private final InstalationService instalationService;

    public InstalationController(InstalationService instalationService) {
        this.instalationService = instalationService;
    }

    @PostMapping
    public ResponseEntity<InstalationDto> getInstalation(@Valid @RequestBody InstalationDtoPK id) {
        return ResponseEntity.ok(instalationService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<InstalationDto>> getInstalation(@RequestParam String entity, @RequestParam String empresa) {
        return ResponseEntity.ok(instalationService.findInstalationsById_EntityAndEmpresa(entity, empresa));
    }


}
