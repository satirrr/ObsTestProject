package com.obs.test.market.model.dto.item.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class GetAllItemRequestDto {
    @NotNull(message = "page is mandatory")
    @Min(value = 1, message = "page must be at least 1")
    @Max(value = 99, message = "page must be at most 99")
    private Integer page;

    @NotNull(message = "size is mandatory")
    private Integer size;

    @NotNull(message = "showStock is mandatory")
    private Boolean showStock;
}
