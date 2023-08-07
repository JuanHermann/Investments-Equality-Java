package com.juanstudy.investmentsequalityjava.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.juanstudy.investmentsequalityjava.Models.Asset;
import com.juanstudy.investmentsequalityjava.Models.Paper;
import com.juanstudy.investmentsequalityjava.databinding.AdapterAssetsBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AssetsAdapter extends RecyclerView.Adapter<AssetsAdapter.ViewHolder> {

    private List<Asset> assets;

    public AssetsAdapter() {
        assets = new ArrayList<>();
    }

    @Override
    @NotNull
    public AssetsAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        AdapterAssetsBinding binding = AdapterAssetsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Asset dataModel = assets.get(position);
        holder.bind(dataModel);
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return assets.size();
    }

    public void setAssetsData(List<Paper> paperList) {

        for (Paper paper : paperList) {
            for (Asset asset : assets) {
                if (paper.getCodigo().equals(asset.getTag().toUpperCase())) {
                    asset.setPrice(Double.parseDouble(paper.getUltimo().replace(",", ".")));
                    notifyItemChanged(assets.indexOf(asset));
                }
            }
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public AdapterAssetsBinding binding;

        public ViewHolder(AdapterAssetsBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.binding = itemRowBinding;
        }

        public void bind(Asset asset) {
            binding.tvAssetName.setText(asset.getTag());
            binding.tvAssetDateCom.setText(asset.getId() + "/12");
            binding.tvAssetPercent.setText("R$ " + asset.getPrice().toString());
        }
    }

}
