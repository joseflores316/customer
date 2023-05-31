package com.cronos.customer.infraestructure.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstalationEntityPK implements Serializable {

    private String entity;

    private String instance;

    private String subinstance;
}
