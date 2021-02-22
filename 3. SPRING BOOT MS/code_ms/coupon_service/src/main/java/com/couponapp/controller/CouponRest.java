package com.couponapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couponapp.service.Coupon;
import com.couponapp.service.CouponService;

@RestController
public class CouponRest {

		@Autowired
		private CouponService couponService;

		@RequestMapping(value = "/api/coupon/{couponcode}", 
				method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Coupon> getAnCoupon(@PathVariable String couponcode) {
			Coupon coupon = couponService.getCouponByCode(couponcode);
			if (coupon==null) {
				return new ResponseEntity<Coupon>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<Coupon>(coupon, HttpStatus.OK);
		}
}
