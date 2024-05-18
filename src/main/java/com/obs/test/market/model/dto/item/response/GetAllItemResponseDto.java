package com.obs.test.market.model.dto.item.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.obs.test.market.custom.Response;
import com.obs.test.market.model.dto.BaseResponse;
import com.obs.test.market.model.dto.item.ItemResponse;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllItemResponseDto extends BaseResponse {
    @JsonProperty(value = "item")
    List<ItemResponse> itemPage;

    @JsonIgnore
    public void setResponse(Response response){
        this.setResponseCode(response.getCode());
        this.setResponseMessage(response.getMessage());
    }
}
