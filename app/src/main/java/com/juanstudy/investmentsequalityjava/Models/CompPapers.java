package com.juanstudy.investmentsequalityjava.Models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CompPapers {
    @SerializedName("results")
    @Expose
    private ArrayList<Paper> results;

    public ArrayList<Paper> getResults() {
        return results;
    }

    @NonNull
    @Override
    public String toString() {
        return results.toString();
    }
}
