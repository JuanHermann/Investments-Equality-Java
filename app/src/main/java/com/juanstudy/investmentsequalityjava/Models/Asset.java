package com.juanstudy.investmentsequalityjava.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "assets")
public class Asset {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String tag;
    private Integer quantity;
    private Double price;
    private Integer dataCom;


    public Asset(String tag) {
        this.id = null;
        this.tag = tag;
        this.quantity = 0;
        this.price = 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDataCom() {
        return dataCom;
    }

    public void setDataCom(Integer dataCom) {
        this.dataCom = dataCom;
    }
}
