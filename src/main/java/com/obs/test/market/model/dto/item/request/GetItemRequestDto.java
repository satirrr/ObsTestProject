package com.obs.test.market.model.dto.item.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetItemRequestDto {
    @NotNull(message = "itemId is mandatory")
    private Integer itemId;
    @NotNull(message = "showStock is mandatory")
    private Boolean showStock;
}