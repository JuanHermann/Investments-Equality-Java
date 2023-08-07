package com.juanstudy.investmentsequalityjava.repository;

import com.juanstudy.investmentsequalityjava.Models.CompPapers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IPaperService {

    @GET("{papers}")
    Call<CompPapers> papersDataList(@Path("papers") String papers);

}
