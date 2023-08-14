package com.juanstudy.investmentsequalityjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.juanstudy.investmentsequalityjava.Models.Asset;
import com.juanstudy.investmentsequalityjava.Models.Paper;
import com.juanstudy.investmentsequalityjava.R;
import com.juanstudy.investmentsequalityjava.databinding.AdapterAssetsBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AssetsAdapter extends RecyclerView.Adapter<AssetsAdapter.ViewHolder> {

    private List<Asset> assets;
    private final Context context;

    public AssetsAdapter(Context context) {
        assets = new ArrayList<>();
        this.context = context;
    }

    @Override
    @NotNull
    public AssetsAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        AdapterAssetsBinding binding = AdapterAssetsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding, context);
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
                    if (paper.getUltimo() != null) {
                        asset.setPrice(Double.parseDouble(paper.getUltimo().replace(",", ".")));
                        notifyItemChanged(assets.indexOf(asset));
                    }
                }
            }
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterAssetsBinding binding;
        private final Context context;

        public ViewHolder(AdapterAssetsBinding itemRowBinding, Context context) {
            super(itemRowBinding.getRoot());
            this.binding = itemRowBinding;
            this.context = context;
        }

        public void bind(Asset asset) {
            binding.tvName.setText(asset.getTag());
            binding.tvQuantity.setText(asset.getQuantity().toString());
            binding.tvMediumPrice.setText(returnValue(asset.getMediumPrice()));
            binding.tvPrice.setText(returnValue(asset.getPrice()));
        }

        public String returnValue(Double price) {
            return context.getString(R.string.show_value, price.toString().replace(".", ","));
        }
    }

}
