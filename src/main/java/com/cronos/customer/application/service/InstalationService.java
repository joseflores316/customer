package com.cronos.customer.application.service;

import com.cronos.customer.domain.models.InstalationDto;
import com.cronos.customer.domain.models.InstalationDtoPK;
import com.cronos.customer.infraestructure.entity.InstalationEntity;

import java.util.List;

public interface InstalationService {

    InstalationDto findById(InstalationDtoPK id);

    List<InstalationDto> findInstalationsById_EntityAndEmpresa(String entity, String empresa);
}
