package zw.co.afrosoft.productservice.restclients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("COUPON-SERVICE")
public interface CouponClient {

}
