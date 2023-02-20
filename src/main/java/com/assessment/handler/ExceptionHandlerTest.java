package com.assessment.handler;


import com.assessment.util.CustomResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerTest {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public CustomResponseEntity processUnmergeException(final MethodArgumentNotValidException ex) {

        List list = ex.getBindingResult().getAllErrors().stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        return new CustomResponseEntity(list, HttpStatus.BAD_REQUEST);
    }
}
