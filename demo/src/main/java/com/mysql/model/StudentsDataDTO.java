package com.mysql.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class StudentsDataDTO implements Serializable {
    private int id;
    private String name;
    private BigDecimal height;
    private transient BigDecimal weight;
    private Integer class_no;

    public StudentsDataDTO(int id, String name, BigDecimal height, BigDecimal weight, Integer class_no) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.class_no = class_no;       
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getClass_no() {
        return class_no;
    }

    public void setClass_no(Integer class_no) {
        this.class_no = class_no;
    }
}