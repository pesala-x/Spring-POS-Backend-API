package lk.ijse.spring_pos.service.impl;

import lk.ijse.spring_pos.customObj.ItemResponse;
import lk.ijse.spring_pos.dao.ItemDAO;
import lk.ijse.spring_pos.dto.ItemDTO;
import lk.ijse.spring_pos.entity.ItemEntity;
import lk.ijse.spring_pos.exception.ItemNotFoundException;
import lk.ijse.spring_pos.service.ItemService;
import lk.ijse.spring_pos.util.DateTimeUtil;
import lk.ijse.spring_pos.util.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private final ItemDAO itemDAO;

    @Autowired
    private final MappingUtil mappingUtil;
    @Override
    public String saveItem(ItemDTO itemDTO) {
        itemDTO.setItemCode(generateItemID());
        itemDTO.setRegisterDate(DateTimeUtil.getCurrentDate());
        ItemEntity itemEntity = mappingUtil.convertToItemEntity(itemDTO);
        itemDAO.save(itemEntity);
        System.out.println("Item saved : " + itemEntity);
        return "Item saved successfully";
    }

    @Override
    public void updateItem(String id, ItemDTO itemDTO) {
        Optional<ItemEntity> tmpItem = itemDAO.findById(id);
        if (!tmpItem.isPresent()) {
            System.out.println("Item not found");
            throw new ItemNotFoundException("Item not found");
        } else {
            tmpItem.get().setCategory(itemDTO.getCategory());
            tmpItem.get().setUnitPrice(itemDTO.getUnitPrice());
            tmpItem.get().setQtyOnHand(itemDTO.getQtyOnHand());
            tmpItem.get().setExpireDate(itemDTO.getExpireDate());
            System.out.println("Item updated : " + itemDTO);
        }
    }

    @Override
    public void deleteItem(String id) {
        if (itemDAO.existsById(id)) {
            itemDAO.deleteById(id);
            System.out.println("Item deleted : " + id);
        } else {
            System.out.println("Item not found");
            throw new ItemNotFoundException("Item not found");
        }
    }

    @Override
    public ItemResponse getItemById(String id) {
        if (itemDAO.existsById(id)) {
            return mappingUtil.convertToItemDTO(itemDAO.getReferenceById(id));
        } else {
            throw new ItemNotFoundException("Item not found");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mappingUtil.convertToItemDTOList(itemDAO.findAll());
    }

    private String generateItemID() {
        if (itemDAO.count() == 0) {
            return "I001";
        } else {
            String lastId = itemDAO.findAll().get(itemDAO.findAll().size() - 1).getItemCode();
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            if (newId < 10) {
                return "I00" + newId;
            } else if (newId < 100) {
                return "I0" + newId;
            } else {
                return "I" + newId;
            }
        }
    }
}
