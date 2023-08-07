package com.juanstudy.investmentsequalityjava.Models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paper {

    @SerializedName("symbol")
    @Expose
    private String codigo;
    @SerializedName("regularMarketPrice")
    @Expose
    private String ultimo;
    @SerializedName("regularMarketTime")
    @Expose
    private String data;


    public Paper() {
    }

    public Paper(String codigo, String ultimo) {
        this.codigo = codigo;
        this.ultimo = ultimo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public String getUltimo() {
        return ultimo;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "codigo='" + codigo + '\'' +
                ", ultimo='" + ultimo + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
