package com.cronos.customer.domain.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {


    @Schema(name ="id" ,description = "Customer id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @NotNull
    @NotBlank
    @Schema(name ="name" ,description = "Customer name", example = "Jose", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(name ="surname" ,description = "Customer surname", example = "Aylas", requiredMode = Schema.RequiredMode.REQUIRED)
    private String surname;

    private byte[] fichero;
}
