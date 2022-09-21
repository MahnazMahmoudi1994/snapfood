package com.kurdestanbootcamp.snapfood.basket_item;

import com.kurdestanbootcamp.snapfood.basket.Basket;
import com.kurdestanbootcamp.snapfood.basket.BasketDTO;
import com.kurdestanbootcamp.snapfood.basket.BasketMapper;
import com.kurdestanbootcamp.snapfood.basket.IBasketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/basket-item/")
@AllArgsConstructor
public class BasketItemController {

    private final IBasketItemService basketItemService;
    private BasketItemMapper basketItemMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody BasketItemDTO basketItemDTO){
        BasketItem basketItem =basketItemMapper.toBasketItem(basketItemDTO);
        basketItemService.save(basketItem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody BasketItemDTO basketItemDTO){
        BasketItem basketItem =basketItemMapper.toBasketItem(basketItemDTO);
        basketItemService.update(basketItem);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<BasketItemDTO> getById(@PathVariable Long id ){
        BasketItem basketItem = basketItemService.getById(id);
        BasketItemDTO basketItemDTO =basketItemMapper.toBasketItemDTO(basketItem);
        return ResponseEntity.ok(basketItemDTO);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<BasketItemDTO>> getAll(){
        List<BasketItem> basketItems= basketItemService.getAll();
        List<BasketItemDTO> basketItemDTOS = basketItemMapper.toBasketItemDTOS(basketItems);

        return ResponseEntity.ok(basketItemDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        basketItemService.delete(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/v1/get-all-by-basket/{basketId}")
    public ResponseEntity<List<BasketItemDTO>> getAllByBasket(@PathVariable Long basketId){
        List<BasketItem> basketItems= basketItemService.getAllByBasket(basketId);
        List<BasketItemDTO> basketItemDTOS = basketItemMapper.toBasketItemDTOS(basketItems);

        return ResponseEntity.ok(basketItemDTOS);
    }

    @GetMapping("/v1/get-all-by-item/{itemId}")
    public ResponseEntity<List<BasketItemDTO>> getAllByItem(@PathVariable Long itemId){
        List<BasketItem> basketItems= basketItemService.getAllByItem(itemId);
        List<BasketItemDTO> basketItemDTOS = basketItemMapper.toBasketItemDTOS(basketItems);

        return ResponseEntity.ok(basketItemDTOS);
    }
}
