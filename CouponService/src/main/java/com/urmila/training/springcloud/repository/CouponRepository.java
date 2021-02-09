package com.urmila.training.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urmila.training.springcloud.model.Coupon;
@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long> {

	Coupon findByCode(String code);

}
