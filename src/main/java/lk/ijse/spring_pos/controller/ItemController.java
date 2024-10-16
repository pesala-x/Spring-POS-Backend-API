package lk.ijse.spring_pos.controller;

import lk.ijse.spring_pos.dto.ItemDTO;
import lk.ijse.spring_pos.exception.DataPersistFailedException;
import lk.ijse.spring_pos.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private final ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(@RequestBody ItemDTO itemDTO) {
        if (itemDTO == null) {
            return ResponseEntity.badRequest().build();
        } else {
            try {
                itemService.saveItem(itemDTO);
                return ResponseEntity.created(null).build();
            } catch (DataPersistFailedException e) {
                return ResponseEntity.badRequest().build();
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }
        }
    }
}
