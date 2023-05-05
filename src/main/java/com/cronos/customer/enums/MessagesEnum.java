package com.cronos.customer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagesEnum {

    ENTITY_NOT_EXISTS("entity.not.exists");

    private final String code;
}
