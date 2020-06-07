package com.atguigu.gulimall.product.service.impl;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;
import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Function;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查询所有的分类信息，并组装父子结构
     * @return
     */
    @Override
    public List<CategoryEntity> queryWithTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        List<CategoryEntity> collect = categoryEntities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0
        ).map(menu -> {
            menu.setChildren(getChildren(menu, categoryEntities));
            return menu;
        }).sorted(
                Comparator.comparing(CategoryEntity::getSort)
        ).collect(Collectors.toList());
        return collect;
    }

    /**
     * 递归查找子节点返回
     *
     * @param root
     * @param all
     * @return
     */
    public List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> child = all.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == root.getCatId()
        ).map(menu -> {
            menu.setChildren(getChildren(menu, all));
            return menu;
        }).sorted(
                Comparator.comparing(categoryEntity ->
                        //为空的情况判断处理
                        categoryEntity.getSort(), Comparator.nullsLast(Integer::compareTo)
                )
        ).collect(Collectors.toList());
        return child;
    }
}