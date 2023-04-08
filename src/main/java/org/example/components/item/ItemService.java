package org.example.components.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final MyItemRepository myItemRepository;
    @Autowired
    public ItemService(ItemRepository itemRepository, MyItemRepository myItemRepository) {
        this.itemRepository = itemRepository;
        this.myItemRepository = myItemRepository;
    }

    public Iterable<Item> findAll(){
        return itemRepository.findAll();
    }

    public void save(Item item){
        itemRepository.save(item);
    }

    public void deleteById(Long id){
        itemRepository.deleteById(id);
    }

    public Optional<Item> findById(Long id){
        return itemRepository.findById(id);
    }

    public Iterable<Item> filter(String category, String pet, Double purchasePrice, Double sellingPrice){
        return myItemRepository.filter(category, pet, purchasePrice, sellingPrice);
    }
}
