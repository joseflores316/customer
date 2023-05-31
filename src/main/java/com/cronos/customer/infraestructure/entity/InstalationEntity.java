package com.cronos.customer.infraestructure.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "INSTALATIONS")
public class InstalationEntity implements Serializable {

    @EmbeddedId
    private InstalationEntityPK id = new InstalationEntityPK();

    private byte[] file;

    private String name;

    private String empresa;


}
