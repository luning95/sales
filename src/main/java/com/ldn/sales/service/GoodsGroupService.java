package com.ldn.sales.service;

import com.ldn.sales.dao.GoodsGroupDao;
import com.ldn.sales.entity.GoodsGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsGroupService")
public class GoodsGroupService {

    @Autowired
    GoodsGroupDao goodsGroupDao;

    public List<GoodsGroup> getList() {
        return goodsGroupDao.getList();
    }

    public List<GoodsGroup> getListOfCascade() {
        return goodsGroupDao.getListOfCascade();
    }

}
