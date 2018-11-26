package com.ldn.sales.dao;

import com.ldn.sales.entity.GoodsGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsGroupDao {
    int insert(GoodsGroup record);

    int insertSelective(GoodsGroup record);

    List<GoodsGroup> getList();

    List<GoodsGroup> getListOfCascade();
}