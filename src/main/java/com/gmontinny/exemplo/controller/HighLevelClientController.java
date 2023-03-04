package com.gmontinny.exemplo.controller;

import java.util.Map;

import com.gmontinny.exemplo.model.Product;
import com.gmontinny.exemplo.service.HighLevelClientProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/high-level-client")
@RequiredArgsConstructor
public class HighLevelClientController {

    private final HighLevelClientProductService highLevelClientProductService;

    @GetMapping("{id}")
    public Product getProductById(@PathVariable String id) {
        return highLevelClientProductService.getProduct(id);
    }

    @GetMapping("aggregate/{term}")
    public Map<String, Long> aggregateByTerms(@PathVariable String term) {
        return highLevelClientProductService.aggregateTerm(term);
    }

    @PostMapping("/product/_create-index")
    public boolean createIndex(){
        return highLevelClientProductService.createProductIndex();
    }


}
