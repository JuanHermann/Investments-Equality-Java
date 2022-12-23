package com.juanstudy.investmentsequalityjava.repository;

import com.juanstudy.investmentsequalityjava.Models.CompPapers;
import com.juanstudy.investmentsequalityjava.retrofit.RetrofitConfig;

import retrofit2.Callback;

public class PaperService {

    public void papersDataList(String papers, Callback<CompPapers> call) {
        RetrofitConfig.getInstancePaper().papersDataList(papers).enqueue(call);
    }


}
