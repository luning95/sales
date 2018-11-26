package com.ldn.sales.entity;

import java.io.Serializable;
import java.util.Date;


public class Goods implements Serializable {
    private Long goodsId;

    private String goodsCode;

    private String goodsName;

    private String goodsPrice;

    private String goodsUnit;

    private String goodsNum;

    private Byte goodsState;

    private Date goodsStateStartTime;

    private Byte goodsPriceState;

    private Date goodsPriceStateStartTime;

    private String goodsDist;

    private Byte goodsClassifyState;

    private String goodsImg;

    private Long ggId;

    private GoodsGroup goodsGroup;

    public GoodsGroup getGoodsGroup() {
        return goodsGroup;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsCode='" + goodsCode + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsUnit='" + goodsUnit + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                ", goodsState=" + goodsState +
                ", goodsStateStartTime=" + goodsStateStartTime +
                ", goodsPriceState=" + goodsPriceState +
                ", goodsPriceStateStartTime=" + goodsPriceStateStartTime +
                ", goodsDist='" + goodsDist + '\'' +
                ", goodsClassifyState=" + goodsClassifyState +
                ", goodsImg='" + goodsImg + '\'' +
                ", ggId=" + ggId +
                ", goodsGroup=" + goodsGroup +
                '}';
    }

    public void setGoodsGroup(GoodsGroup goodsGroup) {
        this.goodsGroup = goodsGroup;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice == null ? null : goodsPrice.trim();
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit == null ? null : goodsUnit.trim();
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum == null ? null : goodsNum.trim();
    }

    public Byte getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Byte goodsState) {
        this.goodsState = goodsState;
    }

    public Date getGoodsStateStartTime() {
        return goodsStateStartTime;
    }

    public void setGoodsStateStartTime(Date goodsStateStartTime) {
        this.goodsStateStartTime = goodsStateStartTime;
    }

    public Byte getGoodsPriceState() {
        return goodsPriceState;
    }

    public void setGoodsPriceState(Byte goodsPriceState) {
        this.goodsPriceState = goodsPriceState;
    }

    public Date getGoodsPriceStateStartTime() {
        return goodsPriceStateStartTime;
    }

    public void setGoodsPriceStateStartTime(Date goodsPriceStateStartTime) {
        this.goodsPriceStateStartTime = goodsPriceStateStartTime;
    }

    public String getGoodsDist() {
        return goodsDist;
    }

    public void setGoodsDist(String goodsDist) {
        this.goodsDist = goodsDist == null ? null : goodsDist.trim();
    }

    public Byte getGoodsClassifyState() {
        return goodsClassifyState;
    }

    public void setGoodsClassifyState(Byte goodsClassifyState) {
        this.goodsClassifyState = goodsClassifyState;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public Long getGgId() {
        return ggId;
    }

    public void setGgId(Long ggId) {
        this.ggId = ggId;
    }
}