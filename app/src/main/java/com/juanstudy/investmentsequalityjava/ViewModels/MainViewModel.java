package com.juanstudy.investmentsequalityjava.ViewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.juanstudy.investmentsequalityjava.Models.Asset;
import com.juanstudy.investmentsequalityjava.Models.CompPapers;
import com.juanstudy.investmentsequalityjava.repository.AssetRepository;

import java.util.List;

import retrofit2.Callback;

public class MainViewModel extends ViewModel {

    private final MainModel model = MainModel.getInstance();
    private final AssetRepository repository;
    private LiveData<List<Asset>> assets;

    public MainViewModel() {
        repository = new AssetRepository();
        assets = new MutableLiveData<>();
        assets = repository.getAllAssets();
    }

    public void getPapersInfo(Callback<CompPapers> callback) {
        String papers = "";
        for (Asset asset : assets.getValue()) {
            papers += asset.getTag() + "|";
        }
        Log.i("JUAN", "Papers = " + papers);
        model.getPapers(papers, callback);
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
