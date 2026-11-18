package com.example.uptime_service.common;

/**
 * Will be thrown if a requested ressource does not exist.
 * 404 will be executed by the GlobalExceptionHandler.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, Object id) {
        super(resource + " " + id + " nicht gefunden");
    }
}
