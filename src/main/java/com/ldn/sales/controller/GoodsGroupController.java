package com.ldn.sales.controller;

import com.ldn.sales.common.ResultDto;
import com.ldn.sales.entity.Goods;
import com.ldn.sales.entity.GoodsGroup;
import com.ldn.sales.service.GoodsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("goodsGroup")
@Scope("prototype")
public class GoodsGroupController {

    @Autowired
    GoodsGroupService goodsGroupService;

    @GetMapping("getGoodsGroup")
    @ResponseBody
    public ResultDto getGoodsGroupList() {
        List<GoodsGroup> list = goodsGroupService.getList();
        ResultDto resultDto = new ResultDto();
        resultDto.setBool(true);
        resultDto.setMessage("成功");
        resultDto.setObject(list);
        resultDto.setRetCode(1);
        return resultDto;
    }

    @GetMapping("getListOfCascade")
    @ResponseBody
    public ResultDto getListOfCascade() {
        List<GoodsGroup> list = goodsGroupService.getListOfCascade();
        for (GoodsGroup goodsGroup : list) {
            if (goodsGroup.getGoodsList() != null) {
                System.out.println("goodsGroup.getGoodsList().size():" + goodsGroup.getGoodsList().size());
                for (Goods goods:goodsGroup.getGoodsList())
                {
                      if(goods!=null){
                       System.out.println("goods.getGgId():"+goods.getGgId());
                      }
                }
            }
        }

        ResultDto resultDto = new ResultDto();
        resultDto.setBool(true);
        resultDto.setMessage("成功");
        resultDto.setObject(list);
        resultDto.setRetCode(1);
        return resultDto;
    }
}
