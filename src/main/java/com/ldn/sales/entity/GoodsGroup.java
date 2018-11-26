package com.ldn.sales.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.List;

public class GoodsGroup implements Serializable {
    private Long ggId;

    private String ggCode;

    private String ggName;

    private String ggNode;

    private String ggParentNode;

    private String ggImg;

    private List<Goods> goodsList;


    @Override
    public String toString() {
        return "GoodsGroup{" +
                "ggId=" + ggId +
                ", ggCode='" + ggCode + '\'' +
                ", ggName='" + ggName + '\'' +
                ", ggNode='" + ggNode + '\'' +
                ", ggParentNode='" + ggParentNode + '\'' +
                ", ggImg='" + ggImg + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }


    public Long getGgId() {
        return ggId;
    }

    public void setGgId(Long ggId) {
        this.ggId = ggId;
    }

    public String getGgCode() {
        return ggCode;
    }

    public void setGgCode(String ggCode) {
        this.ggCode = ggCode == null ? null : ggCode.trim();
    }

    public String getGgName() {
        return ggName;
    }

    public void setGgName(String ggName) {
        this.ggName = ggName == null ? null : ggName.trim();
    }

    public String getGgNode() {
        return ggNode;
    }

    public void setGgNode(String ggNode) {
        this.ggNode = ggNode == null ? null : ggNode.trim();
    }

    public String getGgParentNode() {
        return ggParentNode;
    }

    public void setGgParentNode(String ggParentNode) {
        this.ggParentNode = ggParentNode == null ? null : ggParentNode.trim();
    }

    public String getGgImg() {
        return ggImg;
    }

    public void setGgImg(String ggImg) {
        this.ggImg = ggImg == null ? null : ggImg.trim();
    }
}