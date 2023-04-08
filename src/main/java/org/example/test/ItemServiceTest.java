package org.example.test;

import org.example.components.item.Item;
import org.example.components.item.ItemRepository;
import org.example.components.item.ItemService;
import java.util.Optional;
import org.example.components.item.MyItemRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private MyItemRepository myItemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void testFindAll() {
        //Mock data
        List<Item> itemList = Arrays.asList(
                new Item(1L, "category1", "pet1", 10.0, 20.0),
                new Item(2L, "category2", "pet2", 15.0, 25.0)
        );

        //Mock the behavior of the itemRepository
        Mockito.when(itemRepository.findAll()).thenReturn(itemList);

        //Get the actual result
        Iterable<Item> result = itemService.findAll();

        //Assert result
        Assert.assertEquals(itemList.size(), ((List<Item>) result).size());
    }

    @Test
    public void testSave() {
        //Mock data
        Item item = new Item(1l, "category1", "pet1", 10.0, 20.0);

        //Call the save method
        itemService.save(item);

        //Verify that the save method of itemRepository is called
        Mockito.verify(itemRepository, Mockito.times(1)).save(item);
    }

    @Test
    public void testDeleteById() {
        //Mock data
        Long id = 1L;

        //Call the deleteById method
        itemService.deleteById(id);

        //Verify that the deleteById method of itemRepository is called
        Mockito.verify(itemRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void testFindById() {
        //Mock data
        Long id = 1L;
        Item item = new Item(id, "category1", "pet1", 10.0, 20.0);

        //Mock the behavior of the itemRepository
        Mockito.when(itemRepository.findById(id)).thenReturn(Optional.of(item));

        //Get the actual result
        Optional<Item> result = itemService.findById(id);

        //Assert result
        Assert.assertEquals(item, result.get());
    }

    @Test
    public void testFilter() {
        //Mock data
        List<Item> itemList = Arrays.asList(
                new Item(1L, "category1", "pet1", 10.0, 20.0),
                new Item(2L, "category2", "pet2", 15.0, 25.0)
        );

        //Mock the behavior of the myItemRepository
        Mockito.when(myItemRepository.filter("category1", null, null, null)).thenReturn(itemList);

        //Get the actual result
        Iterable<Item> result = itemService.filter("category1", null, null, null);

        //Assert result
        Assert.assertEquals(itemList.size(), ((List<Item>) result).size());
    }
}