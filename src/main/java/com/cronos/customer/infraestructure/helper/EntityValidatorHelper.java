package com.cronos.customer.infraestructure.helper;

import com.cronos.customer.infraestructure.enums.MessagesEnum;
import com.cronos.customer.infraestructure.exceptions.CronosException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class EntityValidatorHelper {

    private EntityValidatorHelper() {
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> T validateIfExistsAndReturn(JpaRepository repository, final Long id) {
        Optional object = repository.findById(id);

        if(!object.isPresent()) {
            throw new CronosException(MessagesEnum.ENTITY_NOT_EXISTS.getCode() + " with id: " + id + " on " + repository.getClass().getSimpleName());
        }

        return (T) object.get();
    }
}
