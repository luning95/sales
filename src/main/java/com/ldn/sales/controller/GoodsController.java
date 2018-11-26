package com.ldn.sales.controller;

import com.ldn.sales.common.ResultDto;
import com.ldn.sales.entity.Goods;
import com.ldn.sales.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller()
@RequestMapping("goods")
@Scope("prototype")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping("getgoods")
    @ResponseBody
    public ResultDto getGoods() {
        List<Goods> list = goodsService.getListByGGID(33);
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
        List<Goods> list = goodsService.getListOfCascade();
        ResultDto resultDto = new ResultDto();
        resultDto.setBool(true);
        resultDto.setMessage("成功");
        resultDto.setObject(list);
        resultDto.setRetCode(1);
        return resultDto;
    }

}
