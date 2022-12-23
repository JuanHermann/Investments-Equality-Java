package com.juanstudy.investmentsequalityjava.ViewModels;

import com.juanstudy.investmentsequalityjava.Models.CompPapers;
import com.juanstudy.investmentsequalityjava.repository.PaperService;

import retrofit2.Callback;

public class MainModel {

    private static MainModel model;
    private static PaperService service;

    public MainModel() {
    }

    public static synchronized MainModel getInstance() {
        if (model == null) {
            model = new MainModel();
            service = new PaperService();
        }
        return model;
    }

    public void getPapersDataList(String papers, Callback<CompPapers> callback) {
        service.papersDataList(papers, callback);
    }


}
