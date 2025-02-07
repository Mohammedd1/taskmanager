package com.example.taskmanager.common.response;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import java.io.Serializable;

@Data
@Builder
public class ResponseWrapper<T> implements Serializable {

    private int status;
    private String message;
    private T data;


    public ResponseWrapper(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data; // Allow null here
    }

    public ResponseWrapper(int status, String message) {
        this(status, message, null); // Overloaded constructor for no data
    }

}
