package com.juanstudy.investmentsequalityjava.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.juanstudy.investmentsequalityjava.Models.Asset;

import java.util.List;

@Dao
public interface AssetDao {
    @Insert
    void insert(Asset asset);

    @Update
    void update(Asset asset);

    @Delete
    void delete(Asset asset);

    @Query("DELETE FROM assets")
    void deleteAll();

    @Query("SELECT * FROM assets")
    LiveData<List<Asset>> getAllAssets();

    @Query("SELECT * FROM assets WHERE id = :id")
    List<Asset> getById(Integer id);


}
