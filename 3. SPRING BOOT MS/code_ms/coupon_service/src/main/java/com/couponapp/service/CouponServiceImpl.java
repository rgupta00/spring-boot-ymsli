package com.couponapp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {
	private static Map<String, Coupon> Coupons = new HashMap<>();
	static {
		Coupons.put("SUP10",new Coupon(1, "SUP10", 10, new Date()));
		Coupons.put("SUP20",new Coupon(1, "SUP20", 20, new Date()));

	}


	@Override
	public Coupon getCouponByCode(String couponCode) {
		return Coupons.get(couponCode);
	}

}
