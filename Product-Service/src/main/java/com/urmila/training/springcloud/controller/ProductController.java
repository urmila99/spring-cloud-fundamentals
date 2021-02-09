package com.urmila.training.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.urmila.training.springcloud.feignclient.CouponClient;
import com.urmila.training.springcloud.model.Coupon;
import com.urmila.training.springcloud.model.Product;
import com.urmila.training.springcloud.repository.ProductRepository;

@RestController
@RequestMapping("/productsapi")
@RefreshScope
public class ProductController {
	
	@Autowired
	CouponClient couponClient;

	@Autowired
	private ProductRepository productRepository;
	
	@Value("${com.urmila.training.prop}")
	private String prop;
	
	@HystrixCommand(fallbackMethod="sendErrorResponse")
	@PostMapping("/product")
	public Product create(@RequestBody Product product) {
		System.out.println(product.getCouponCode());
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepository.save(product);

	}
	public Product sendErrorResponse( Product product) {
		return product;
	}
    @GetMapping("/prop")
    public String getProp()
    {
    	return this.prop;
    }

}
