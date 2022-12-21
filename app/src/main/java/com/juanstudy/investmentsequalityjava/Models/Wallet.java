package com.juanstudy.investmentsequalityjava.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "wallets")
public class Wallet {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private List<Asset> Assets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Asset> getAssets() {
        return Assets;
    }

    public void setAssets(List<Asset> assets) {
        Assets = assets;
    }
}
