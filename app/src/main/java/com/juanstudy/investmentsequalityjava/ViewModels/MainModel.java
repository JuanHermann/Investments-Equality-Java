package com.juanstudy.investmentsequalityjava.ViewModels;

import com.juanstudy.investmentsequalityjava.Models.CompPapers;
import com.juanstudy.investmentsequalityjava.Models.Paper;
import com.juanstudy.investmentsequalityjava.repository.PaperRepository;

import java.util.List;

import retrofit2.Callback;

public class MainModel {

    private static MainModel model;
    private static PaperRepository repository;
    private List<Paper> paperList;
//    private AssetRepository repository = AssetRepository.getInstance();

    public MainModel() {
    }

    public static synchronized MainModel getInstance() {
        if (model == null) {
            model = new MainModel();
            repository = new PaperRepository();
        }
        return model;
    }

    public void getPapers(String papers, Callback<CompPapers> callback) {

        repository.listRepos(papers, callback);
    }

//    public LiveData<List<Asset>> getAssets() {
//       return repository.getAll();
//    }
}
