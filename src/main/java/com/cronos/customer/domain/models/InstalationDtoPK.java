package com.cronos.customer.domain.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstalationDtoPK {

    private String entity;

    private String instance;

    private String subinstance;
}
