package com.sample.workshopcassandra.service;

import com.sample.workshopcassandra.model.dto.DepartmentDTO;
import com.sample.workshopcassandra.model.dto.ProductDTO;
import com.sample.workshopcassandra.model.entities.Department;
import com.sample.workshopcassandra.model.entities.Product;
import com.sample.workshopcassandra.repositories.ProductRepository;
import com.sample.workshopcassandra.service.exception.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO findByUUIDProduct(UUID uuid){
        Product product = getById(uuid);
        return new ProductDTO(product);
    }

    public Product getById(UUID uuid){
        Optional<Product> product = productRepository.findById(uuid);
        return product.orElseThrow(() -> new ResourceNotFound("ID nao encontrado"));
    }

    public List<ProductDTO> filterAllProductsByDepartment(String department){
        List<Product> products = productRepository.findByDepartment(department);
        return products.stream().map( product -> new ProductDTO(product)).collect(Collectors.toList());
    }

}
