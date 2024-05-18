package com.obs.test.market.service;

import com.obs.test.market.model.dto.item.request.GetAllItemRequestDto;
import com.obs.test.market.model.dto.item.request.GetItemRequestDto;
import com.obs.test.market.model.dto.item.response.GetAllItemResponseDto;
import com.obs.test.market.model.dto.item.response.GetItemResponseDto;
import org.springframework.http.ResponseEntity;

public interface ItemService {
    ResponseEntity<GetItemResponseDto> getItem(GetItemRequestDto itemRequestDto);
    ResponseEntity<GetAllItemResponseDto> getAllItem(GetAllItemRequestDto allItemRequestDto);
}
