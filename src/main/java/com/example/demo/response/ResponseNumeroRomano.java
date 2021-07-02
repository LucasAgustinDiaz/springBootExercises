package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseNumeroRomano extends Throwable {
    private HttpStatus code;
    private Throwable cause;

}
