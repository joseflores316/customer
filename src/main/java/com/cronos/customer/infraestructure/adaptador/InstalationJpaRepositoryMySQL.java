package com.cronos.customer.infraestructure.adaptador;

import com.cronos.customer.domain.models.InstalationDtoPK;
import com.cronos.customer.infraestructure.entity.InstalationEntity;
import com.cronos.customer.infraestructure.entity.InstalationEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface   InstalationJpaRepositoryMySQL extends JpaRepository<InstalationEntity, Long> {

    InstalationEntity findInstalationEntityById(InstalationEntityPK id);

    List<InstalationEntity> findInstalationsById_EntityAndEmpresa(String entity, String empresa);

}
