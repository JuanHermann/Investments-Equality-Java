package com.juanstudy.investmentsequalityjava.retrofit;

import com.juanstudy.investmentsequalityjava.repository.IPaperService;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitConfig {

    private static final String API_URL = "https://bvmf.bmfbovespa.com.br/cotacoes2000/";
    private static IPaperService paperService;

    public static IPaperService getInstancePaper() {
        if (paperService == null) {
            paperService = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build()
                    .create(IPaperService.class);
        }
        return paperService;
    }

}
