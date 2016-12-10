package com.hm.birthday.entity;

public class BaseDicInfo {
    private Integer id;

    private String type;

    private String code;

    private String name;

    private String orderIdx;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOrderIdx() {
        return orderIdx;
    }

    public void setOrderIdx(String orderIdx) {
        this.orderIdx = orderIdx == null ? null : orderIdx.trim();
    }
}