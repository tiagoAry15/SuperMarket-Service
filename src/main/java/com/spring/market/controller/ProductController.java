package com.spring.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.market.model.Product;
import com.spring.market.repository.ProductRepository;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductRepository produtoRepository;

    @GetMapping
    public List<Product> getProducts() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product produto) {
        Product existingProduct = produtoRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(produto.getName());
            existingProduct.setDescription(produto.getDescription());
            existingProduct.setPrice(produto.getPrice());
            return produtoRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}