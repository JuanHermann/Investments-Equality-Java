package com.juanstudy.investmentsequalityjava.ViewModels;

import com.juanstudy.investmentsequalityjava.Models.CompPapers;
import com.juanstudy.investmentsequalityjava.Models.Paper;
import com.juanstudy.investmentsequalityjava.repository.PaperRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    public void getPapers(String papers) {

        repository.listRepos(papers, new Callback<CompPapers>() {
            @Override
            public void onResponse(Call<CompPapers> call, Response<CompPapers> response) {
                System.out.println(response.body().toString());
            }

            @Override
            public void onFailure(Call<CompPapers> call, Throwable t) {
                System.out.println("ERROR");
            }
        });
    }

//    public LiveData<List<Asset>> getAssets() {
//       return repository.getAll();
//    }
}
