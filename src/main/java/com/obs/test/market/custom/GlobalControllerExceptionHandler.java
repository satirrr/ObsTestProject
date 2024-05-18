package com.obs.test.market.custom;

import com.obs.test.market.model.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.obs.test.market.custom.Constant.BAD_REQUEST_ERROR_CODE;


@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BaseResponse response = new BaseResponse();
        response.setResponseCode(BAD_REQUEST_ERROR_CODE);
        response.setResponseMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
        return ResponseEntity.badRequest().body(response);
    }
}