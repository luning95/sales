package com.ldn.sales.service;

import com.ldn.sales.dao.GoodsDao;
import com.ldn.sales.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsService")
public class GoodsService {
    @Autowired
    GoodsDao goodsDao;


    public List<Goods> getList() {
        return goodsDao.getList();
    }
    @Cacheable(cacheNames = "goodsByGGID",sync=true)
    public List<Goods> getListByGGID(Integer gg_id) {

        return goodsDao.getListByGGID(gg_id);
    }

    public List<Goods> getListOfCascade() {
        return goodsDao.getListOfCascade();
    }


}
