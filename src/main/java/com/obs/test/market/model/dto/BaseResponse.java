package com.obs.test.market.model.dto;

import lombok.Data;

@Data
public class BaseResponse {
    private String responseCode;
    private String responseMessage;
}