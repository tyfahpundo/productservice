package zw.co.afrosoft.productservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.productservice.domain.Coupon;
import zw.co.afrosoft.productservice.domain.Product;
import zw.co.afrosoft.productservice.repository.ProductRepository;
import zw.co.afrosoft.productservice.restclients.CouponClient;

@RestController
@RequestMapping("/product/api")
public class ProductRestController {
    @Autowired
    CouponClient couponClient;
    @Autowired
    ProductRepository productRepo;

    @PostMapping("/create-product")
    @Retry(name = "product-api",fallbackMethod = "handleError")
    public Product create(@RequestBody Product product){
        Coupon coupon = couponClient.getCoupon(product.getCouponCode());
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepo.save(product);
    }
    public Product handleError(Product product, Exception exception){
        System.out.println("Inside the Error Handler");
        return product;
    }
}
