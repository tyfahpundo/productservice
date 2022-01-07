package zw.co.afrosoft.productservice.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zw.co.afrosoft.productservice.domain.Coupon;

@FeignClient("GATEWAY-SERVICE")
public interface CouponClient {
    @GetMapping("api/coupons/{code}")
    Coupon getCoupon(@PathVariable String code);
}
