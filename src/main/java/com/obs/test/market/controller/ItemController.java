package com.obs.test.market.controller;

import com.obs.test.market.model.dto.item.request.GetAllItemRequestDto;
import com.obs.test.market.model.dto.item.request.GetItemRequestDto;
import com.obs.test.market.model.dto.item.response.GetAllItemResponseDto;
import com.obs.test.market.model.dto.item.response.GetItemResponseDto;
import com.obs.test.market.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/get")
    public ResponseEntity<GetItemResponseDto> getItem(
            @Valid @RequestBody GetItemRequestDto getItemRequestDto,
            HttpServletRequest request
            ){
        return itemService.getItem(getItemRequestDto);
    }

    @GetMapping("/get-all")
    public ResponseEntity<GetAllItemResponseDto> getItem(
            @Valid @RequestBody GetAllItemRequestDto getItemRequestDto,
            HttpServletRequest request
    ){
        return itemService.getAllItem(getItemRequestDto);
    }
}
