package com.obs.test.market.repository;

import com.obs.test.market.model.entity.Inventory;
import com.obs.test.market.model.entity.Item;
import com.obs.test.market.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        Item item1 = new Item(1, "Pen", 5);
        Item item2 = new Item(2, "Book", 10);
        Item item3 = new Item(3, "Bag", 30);
        Item item4 = new Item(4, "Pencil", 3);
        Item item5 = new Item(5, "Shoe", 45);
        Item item6 = new Item(6, "Box", 5);
        Item item7 = new Item(7, "Cap", 25);
        itemRepository.saveAll(Arrays.asList(item1, item2, item3, item4, item5, item6, item7));

        Inventory inv1 = new Inventory(1, item1, 5, "T");
        Inventory inv2 = new Inventory(2, item2, 10, "T");
        Inventory inv3 = new Inventory(3, item3, 30, "T");
        Inventory inv4 = new Inventory(4, item4, 3, "T");
        Inventory inv5 = new Inventory(5, item5, 45, "T");
        Inventory inv6 = new Inventory(6, item6, 5, "T");
        Inventory inv7 = new Inventory(7, item7, 25, "T");
        Inventory inv8 = new Inventory(8, item5, 10, "W");
        inventoryRepository.saveAll(Arrays.asList(inv1, inv2, inv3, inv4, inv5, inv6, inv7, inv8));

        Order order1 = new Order(1, "01", item1, 2);
        Order order2 = new Order(2, "02", item2, 3);
        Order order3 = new Order(3, "03", item5, 4);
        Order order4 = new Order(4, "04", item4, 1);
        Order order5 = new Order(5, "05", item5, 2);
        Order order6 = new Order(6, "06", item6, 3);
        Order order7 = new Order(7, "07", item1, 5);
        Order order8 = new Order(8, "08", item2, 4);
        Order order9 = new Order(9, "09", item3, 2);
        Order order10 = new Order(10, "010", item4, 3);
        orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4, order5, order6, order7, order8, order9, order10));
    }
}