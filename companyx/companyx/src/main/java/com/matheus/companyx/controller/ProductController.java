package com.matheus.companyx.controller;

import com.matheus.companyx.model.Product;
import com.matheus.companyx.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/")
    public String index() {
        return "Please, read the API docs to see how to use.";
    }

    //Show all product objetcs in the database
    @GetMapping("/show-all")
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    //Find products by its ID
    @GetMapping("/id")
    public Optional<Product> getProductById(@RequestParam Long id) {
        return repository.findById(id);
    }

    //Find products of a product chain
    @GetMapping("/productID")
    public List<Product> productID(@RequestParam Long productID) {
        return repository.findByProductId(productID);
    }

    //Find all products that fits in a time range
    @GetMapping("/rate")
    public List<Product> rate(@RequestParam Date startDate, @RequestParam Date endDate) {
        return repository.findByStartDateBetween(startDate, endDate);
    }

    //Find all products of a certain chain that fits in a price range
    @GetMapping("/price-chain")
    public List<Product> priceChain(@RequestParam Long productId, @RequestParam double minPrice, @RequestParam double maxPrice) {
        return repository.findByProductIdAndPriceBetween(productId, minPrice, maxPrice);
    }

    //List all products that fits in a price range
    @GetMapping("/price-rate")
    public List<Product> priceRate(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return repository.findByPriceBetween(minPrice, maxPrice);
    }

    //Product creation to database
    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return repository.save(product);
    }

    //Product delete from database using ID
    @DeleteMapping("/id")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Deleted successfully!");
    }
}
