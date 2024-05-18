package com.obs.test.market.custom;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Response{
    SUCCESS("200", "success"),
    BAD_REQUEST("400", "bad request"),
    ITEM_NOT_FOUND("400", "Item Not Found"),
    GENERAL_ERROR("500", "Internal Service Error")
    ;
    private final String code;
    private final String message;

}
