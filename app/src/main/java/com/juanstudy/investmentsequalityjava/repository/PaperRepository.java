package com.juanstudy.investmentsequalityjava.repository;

import com.juanstudy.investmentsequalityjava.Models.CompPapers;
import com.juanstudy.investmentsequalityjava.retrofit.RetrofitConfig;

import retrofit2.Callback;

public class PaperRepository {

    public void listRepos(String papers, Callback<CompPapers> call) {
        RetrofitConfig.getInstancePaper().listRepos(papers).enqueue(call);
    }


}
