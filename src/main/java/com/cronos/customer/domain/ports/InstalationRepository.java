package com.cronos.customer.domain.ports;

import com.cronos.customer.domain.models.InstalationDto;
import com.cronos.customer.domain.models.InstalationDtoPK;
import com.cronos.customer.infraestructure.entity.InstalationEntity;

import java.util.List;

public interface InstalationRepository {

    InstalationDto findById(InstalationDtoPK id);

    List<InstalationDto> findInstalationsById_EntityAndEmpresa(String entity, String empresa);
}
