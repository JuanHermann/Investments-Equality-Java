package com.juanstudy.investmentsequalityjava.repository;

import com.juanstudy.investmentsequalityjava.Models.CompPapers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IPaperRepository {

    @GET("FormConsultaCotacoes.asp")
    Call<CompPapers> listRepos(@Query("strListaCodigos") String papers);

}
