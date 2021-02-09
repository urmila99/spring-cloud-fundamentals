package com.urmila.training.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urmila.training.springcloud.model.Coupon;
import com.urmila.training.springcloud.repository.CouponRepository;

@RestController
@RequestMapping("/couponapi")
public class CouponController {
	@Autowired
	CouponRepository couponRepository;

	@PostMapping("/coupons")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponRepository.save(coupon);

	}
    @GetMapping("/coupon/{code}")
    public Coupon getCoupon(@PathVariable String code)
    {
    	System.out.println("server 1");
    	return couponRepository.findByCode(code);
    }
}
