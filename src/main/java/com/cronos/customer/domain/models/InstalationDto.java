package com.cronos.customer.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstalationDto {

    private InstalationDtoPK id;

    private byte[] file;

    private String name;

    private String empresa;
}
