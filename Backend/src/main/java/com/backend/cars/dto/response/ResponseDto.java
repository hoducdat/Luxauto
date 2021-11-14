package com.backend.cars.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class ResponseDto {
    private Object message;
    private Map<String, List<String>> error;
    @JsonProperty("status")
    private int statusCode;
    private Object data;

    public ResponseDto() {
    }

    public ResponseDto(Object data) {
        this.data = data;
    }

    public ResponseDto(Object message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
    public ResponseDto(Map<String, List<String>> error, String message, int statusCode) {
        this.error = error;
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponseDto(Object message, int statusCode, Object data) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Map<String, List<String>> getError() {
        return error;
    }

    public void setError(Map<String, List<String>> error) {
        this.error = error;
    }
}
