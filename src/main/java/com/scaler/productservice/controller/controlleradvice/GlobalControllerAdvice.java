package com.scaler.productservice.controller.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.scaler.productservice.dto.ErrorResponseDTO;
import com.scaler.productservice.exception.ProductNotFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO>  handleProductNotFoundException(Exception ex){
        ErrorResponseDTO errorResponseDTO =  new ErrorResponseDTO();
        errorResponseDTO.setMessage(ex.getMessage());
        errorResponseDTO.setMessageCode(404);
        return new ResponseEntity<>(errorResponseDTO,HttpStatus.NOT_FOUND);
    }
}
