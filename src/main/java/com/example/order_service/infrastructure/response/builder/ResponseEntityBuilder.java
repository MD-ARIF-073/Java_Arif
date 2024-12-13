package com.example.order_service.infrastructure.response.builder;

import com.example.order_service.core.models.BaseDomainModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ResponseEntityBuilder {

    public ResponseEntity<? extends BaseDomainModel> buildOkResponse(BaseDomainModel baseDomainModel) {
        return ResponseEntity.ok(baseDomainModel);
    }

    public <T> ResponseEntity<List<T>> buildOkListResponse(List<T> baseDomainModels) {
        return ResponseEntity.ok(baseDomainModels);
    }

    public <T> ResponseEntity<T> buildOkListResponse(T baseDomainModels) {
        return ResponseEntity.ok(baseDomainModels);
    }

    public ResponseEntity<Map> buildOkResponse(Map baseDomainModel) {
        return ResponseEntity.ok(baseDomainModel);
    }


    public ResponseEntity<?> buildErrorResponse(String errorMessage) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

}
