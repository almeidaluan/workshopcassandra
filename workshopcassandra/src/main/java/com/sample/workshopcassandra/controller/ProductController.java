package com.sample.workshopcassandra.controller;

import com.sample.workshopcassandra.model.dto.ProductDTO;
import com.sample.workshopcassandra.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO findByUUIDProduct(@PathVariable UUID id){
        return productService.findByUUIDProduct(id);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> filterAllProductsByDepartment(@RequestParam(name = "department",defaultValue = "") String department){
        return ResponseEntity.ok(productService.filterAllProductsByDepartment(department));
    }
}
