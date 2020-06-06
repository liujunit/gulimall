package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author liujun
 * @email 156315348@qq.com
 * @date 2020-05-31 10:02:46
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
