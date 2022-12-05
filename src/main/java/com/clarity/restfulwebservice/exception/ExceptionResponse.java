package com.clarity.restfulwebservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ExceptionResponse {
    private Date time;
    private String exceptionMessage;
    private String exceptionDetails;
}
