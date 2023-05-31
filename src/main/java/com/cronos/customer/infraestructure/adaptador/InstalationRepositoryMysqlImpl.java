package com.cronos.customer.infraestructure.adaptador;

import com.cronos.customer.domain.models.InstalationDto;
import com.cronos.customer.domain.models.InstalationDtoPK;
import com.cronos.customer.domain.ports.InstalationRepository;
import com.cronos.customer.infraestructure.entity.InstalationEntity;
import com.cronos.customer.infraestructure.entity.InstalationEntityPK;
import com.cronos.customer.infraestructure.rest.mapper.InstalationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class InstalationRepositoryMysqlImpl implements InstalationRepository {

    private final InstalationJpaRepositoryMySQL instalationJpaRepositoryMySQL;

    @Autowired
    private InstalationMapper instalationMapper;

    public InstalationRepositoryMysqlImpl(InstalationJpaRepositoryMySQL instalationJpaRepositoryMySQL) {
        this.instalationJpaRepositoryMySQL = instalationJpaRepositoryMySQL;
    }

    @Override
    public InstalationDto findById(InstalationDtoPK instalationDtoPK) {

        InstalationEntityPK instalationEntityPK = new InstalationEntityPK();
        instalationEntityPK.setEntity(instalationDtoPK.getEntity());
        instalationEntityPK.setInstance(instalationDtoPK.getInstance());
        instalationEntityPK.setSubinstance(instalationDtoPK.getSubinstance());

        InstalationEntity instalationEntityByPk = this.instalationJpaRepositoryMySQL.findInstalationEntityById(instalationEntityPK);


        return instalationMapper.toDto(instalationEntityByPk);
    }

    @Override
    public List<InstalationDto> findInstalationsById_EntityAndEmpresa(String entity, String empresa) {


        return instalationMapper.toDtoList(this.instalationJpaRepositoryMySQL.findInstalationsById_EntityAndEmpresa(entity, empresa));
    }
}
