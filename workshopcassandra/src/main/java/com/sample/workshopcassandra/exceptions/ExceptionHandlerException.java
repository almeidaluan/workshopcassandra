package com.sample.workshopcassandra.exceptions;

import com.sample.workshopcassandra.service.exception.ResourceNotFound;
import com.sample.workshopcassandra.util.DateUtil;
import com.sample.workshopcassandra.util.IDateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerException {

    private final IDateUtil dateUtil;

    public ExceptionHandlerException(IDateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }


    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFound e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError();
        error.setError("Not Found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        error.setStatus(status.value());
        error.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(status).body(error);
    }
}
