package zw.co.afrosoft.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.productservice.domain.Product;
import zw.co.afrosoft.productservice.repository.ProductRepository;

@RestController
@RequestMapping("/product/api")
public class ProductRestController {
    @Autowired
    ProductRepository productRepo;
    @PostMapping("/create-product")
    public Product create(@RequestBody Product product){
        return productRepo.save(product);
    }
}
