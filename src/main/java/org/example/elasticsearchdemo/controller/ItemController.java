package org.example.elasticsearchdemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.elasticsearchdemo.dto.SearchRequestDto;
import org.example.elasticsearchdemo.model.Item;
import org.example.elasticsearchdemo.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public Item createIndex(@RequestBody Item item) {
        return itemService.createIndex(item);
    }

    @PostMapping("/init-index")
    public void addItemsFromJson() {
        itemService.addItemsFromJson();
    }

    @GetMapping("/getAllDataFromIndex/{indexName}")
    public List<Item> getAllDataFromIndex(@PathVariable String indexName) {
        return itemService.getAllDataFromIndex(indexName);
    }

    @GetMapping("/search")
    public List<Item> searchItemsByFieldAndValue(@RequestBody SearchRequestDto dto) {
        return itemService.searchItemsByFieldAndValue(dto);
    }

    @GetMapping("/search/{name}/{brand}")
    public List<Item> searchItemsByNameAndBrandWithQuery(@PathVariable String name,
                                                         @PathVariable String brand) {
        return itemService.searchItemsByNameAndBrandWithQuery(name, brand);
    }

    @GetMapping("/boolQuery")
    public List<Item> boolQuery(@RequestBody SearchRequestDto dto) {
        return itemService.boolQuery(dto);
    }

    @GetMapping("/autoSuggest/{name}")
    public Set<String> autoSuggestItemsByName(@PathVariable String name) {
        return itemService.findSuggestedItemNames(name);
    }

    @GetMapping("/suggestionsQuery/{name}")
    public List<String> autoSuggestItemsByNameWithQuery(@PathVariable String name) {
        return itemService.autoSuggestItemsByNameWithQuery(name);
    }


}
