package com.ldn.sales.dao;

import com.ldn.sales.entity.Dict;

public interface DictDao {
    int insert(Dict record);

    int insertSelective(Dict record);
}