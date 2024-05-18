package com.obs.test.market.model.dto.item;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemResponse {
    private Integer itemId;
    private String name;
    private Integer price;
    private Integer quantity;
}
