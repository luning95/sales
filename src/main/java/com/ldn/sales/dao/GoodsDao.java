package com.ldn.sales.dao;

import com.ldn.sales.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> getList();

    List<Goods> getListByGGID(Integer gg_id);

    List<Goods> getListOfCascade();
}