package com.juanstudy.investmentsequalityjava.retrofit;

import com.juanstudy.investmentsequalityjava.repository.IPaperRepository;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitConfig {

    private static Retrofit retrofit;
    private static IPaperRepository paperRepository;

    public static Retrofit getInstance() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://bvmf.bmfbovespa.com.br/cotacoes2000/")
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static IPaperRepository getInstancePaper() {

        if (paperRepository == null) {
            paperRepository = new Retrofit.Builder()
                    .baseUrl("https://bvmf.bmfbovespa.com.br/cotacoes2000/")
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build()
                    .create(IPaperRepository.class);
        }
        return paperRepository;
    }

}
