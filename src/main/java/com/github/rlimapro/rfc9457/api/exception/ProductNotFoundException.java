package com.github.rlimapro.rfc9457.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

import java.net.URI;
import java.time.Instant;

public class ProductNotFoundException extends RuntimeException implements ErrorResponse {

    public ProductNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public ProblemDetail getBody() {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(getStatusCode(), getMessage());
        problemDetail.setTitle("Produto Não Encontrado");
        problemDetail.setType(URI.create("https://localhost:8080/errors/produto-nao-encontrado"));
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

}
