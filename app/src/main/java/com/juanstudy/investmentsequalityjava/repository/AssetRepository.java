package com.juanstudy.investmentsequalityjava.repository;

import androidx.lifecycle.LiveData;

import com.juanstudy.investmentsequalityjava.Models.Asset;
import com.juanstudy.investmentsequalityjava.dao.AssetDao;
import com.juanstudy.investmentsequalityjava.database.ProjectDatabase;

import java.util.List;

public class AssetRepository {

    private AssetDao assetDao;
    private LiveData<List<Asset>> allAssets;

    public AssetRepository() {
        ProjectDatabase db = ProjectDatabase.getDatabase();
        assetDao = db.assetDao();
        allAssets = assetDao.getAllAssets();
    }

    public LiveData<List<Asset>> getAllAssets() {
        return allAssets;
    }

    public void insert(Asset asset) {
        ProjectDatabase.databaseWriteExecutor.execute(() -> assetDao.insert(asset));
    }

    public void deleteAll() {
        ProjectDatabase.databaseWriteExecutor.execute(() -> assetDao.deleteAll());
    }


}