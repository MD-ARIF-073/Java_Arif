package com.example.order_service.core.shared.exceptions;

import com.example.order_service.core.constant.HttpStatusCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataNotFoundException extends RuntimeException{

    private final HttpStatusCode httpStatusCode;

    public DataNotFoundException(final String message, HttpStatusCode httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

}
