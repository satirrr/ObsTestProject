package com.obs.test.market.service.impl;

import com.obs.test.market.custom.Response;
import com.obs.test.market.model.dto.item.ItemResponse;
import com.obs.test.market.model.dto.item.request.GetAllItemRequestDto;
import com.obs.test.market.model.dto.item.request.GetItemRequestDto;
import com.obs.test.market.model.dto.item.response.GetAllItemResponseDto;
import com.obs.test.market.model.dto.item.response.GetItemResponseDto;
import com.obs.test.market.model.entity.Inventory;
import com.obs.test.market.model.entity.Item;
import com.obs.test.market.repository.InventoryRepository;
import com.obs.test.market.repository.ItemRepository;
import com.obs.test.market.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public ResponseEntity<GetItemResponseDto> getItem(GetItemRequestDto itemRequestDto) {
        GetItemResponseDto response = new GetItemResponseDto();
        ItemResponse itemResponse = new ItemResponse();
        Inventory inventory = new Inventory();
        try{
            Optional<Item> optionalItem = itemRepository.findById(itemRequestDto.getItemId());
            if (optionalItem.isPresent()){
                Item item = optionalItem.get();
                itemResponse.setItemId(item.getId());
                itemResponse.setName(item.getName());
                itemResponse.setPrice(item.getPrice());
            }else {
                response.setResponse(Response.ITEM_NOT_FOUND);
                return ResponseEntity.badRequest().body(response);
            }
            if (itemRequestDto.getShowStock()){
                inventory = inventoryRepository.findByItemId(itemRequestDto.getItemId());
                itemResponse.setQuantity(inventory.getQuantity());
            }
        } catch (Exception e){
            log.error(e.getMessage());
            response.setResponse(Response.GENERAL_ERROR);
            return ResponseEntity.internalServerError().body(response);
        }
        response.setResponse(Response.SUCCESS);
        response.setItem(itemResponse);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<GetAllItemResponseDto> getAllItem(GetAllItemRequestDto allItemRequestDto) {
        GetAllItemResponseDto response = new GetAllItemResponseDto();
        List<ItemResponse> itemResponses = new ArrayList<>();
        try {
            PageRequest pageable = PageRequest.of(allItemRequestDto.getPage() - 1, allItemRequestDto.getSize());
            Page<Item> itemPage = itemRepository.findAll(pageable);
            List<Item> itemList = itemPage.getContent();
            if(!itemList.isEmpty()){
                for (Item item : itemList) {
                    ItemResponse itemResponse = new ItemResponse();
                    itemResponse.setItemId(item.getId());
                    itemResponse.setName(item.getName());
                    itemResponse.setPrice(item.getPrice());
                    if (allItemRequestDto.getShowStock()){
                        Inventory inventory = inventoryRepository.findByItemId(item.getId());
                        itemResponse.setQuantity(inventory.getQuantity());
                    }
                    itemResponses.add(itemResponse);
                }
            }
        }catch (Exception e){
            log.error(e.getMessage());
            response.setResponse(Response.GENERAL_ERROR);
            return ResponseEntity.internalServerError().body(response);
        }
        response.setResponse(Response.SUCCESS);
        response.setItemPage(itemResponses);
        return ResponseEntity.ok().body(response);
    }
}
