package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author liujun
 * @email 156315348@qq.com
 * @date 2020-05-31 16:55:01
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
