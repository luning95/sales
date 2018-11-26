package com.ldn.sales.entity;

public class Dict {
    private Integer id;

    private String code;

    private String text;

    private String type;

    private String value;

    private String isLoad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getIsLoad() {
        return isLoad;
    }

    public void setIsLoad(String isLoad) {
        this.isLoad = isLoad == null ? null : isLoad.trim();
    }
}