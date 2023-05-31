package com.cronos.customer.application.service.impl;

import com.cronos.customer.application.service.CustomerService;
import com.cronos.customer.application.service.InstalationService;
import com.cronos.customer.domain.models.InstalationDto;
import com.cronos.customer.domain.models.InstalationDtoPK;
import com.cronos.customer.domain.ports.InstalationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstalationServiceImpl implements InstalationService {

    private final InstalationRepository instalationRepository;

    private final CustomerService customerService;

    public InstalationServiceImpl(InstalationRepository instalationRepository, CustomerService customerService) {
        this.instalationRepository = instalationRepository;
        this.customerService = customerService;
    }


    @Override
    public InstalationDto findById(InstalationDtoPK id) {
        return this.instalationRepository.findById(id);
    }

    @Override
    public List<InstalationDto> findInstalationsById_EntityAndEmpresa(String entity, String empresa) {

        customerService.findById(3L);

        return this.instalationRepository.findInstalationsById_EntityAndEmpresa(entity, empresa);
    }
}
