package com.juanstudy.investmentsequalityjava.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.juanstudy.investmentsequalityjava.Models.Asset;
import com.juanstudy.investmentsequalityjava.repository.AssetRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    private final MainModel model = MainModel.getInstance();
    private final AssetRepository repository;
    private LiveData<List<Asset>> assets;

    public MainViewModel() {
        repository = new AssetRepository();
        assets = new MutableLiveData<>();
        assets = repository.getAllAssets();
    }

    public void getPapersInfo(List<Asset> assets) {
        model.getPapers("HGLG11");
    }

    public void loadData() {
        assets = repository.getAllAssets();
    }

    public void insert(Asset asset) {
        repository.insert(asset);
    }


    public LiveData<List<Asset>> getAssets() {
        return assets;
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
