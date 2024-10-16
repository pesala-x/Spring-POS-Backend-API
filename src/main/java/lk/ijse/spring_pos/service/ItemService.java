package lk.ijse.spring_pos.service;

import lk.ijse.spring_pos.customObj.ItemResponse;
import lk.ijse.spring_pos.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemDTO itemDTO);
    void updateItem(String id, ItemDTO itemDTO);
    void deleteItem(String id);
    ItemResponse getItemById(String id);
    List<ItemDTO> getAllItems();
}
