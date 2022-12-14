package com.mahdiyeh.restfulwebservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ExceptionResponse {
    private Date time;
    private String reason;
    private String details;
}
