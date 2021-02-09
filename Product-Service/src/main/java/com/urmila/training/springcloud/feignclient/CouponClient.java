package com.urmila.training.springcloud.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.urmila.training.springcloud.model.Coupon;

@FeignClient(name="zuul-proxy")
//@RibbonClient(name="coupon-service")
public interface CouponClient {
	@GetMapping("/coupon-service/couponapi/coupon/{code}")
	Coupon getCoupon(@PathVariable String code);

}
