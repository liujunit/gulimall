package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author liujun
 * @email 156315348@qq.com
 * @date 2020-05-31 16:44:43
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
