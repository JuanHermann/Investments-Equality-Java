package com.juanstudy.investmentsequalityjava.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.juanstudy.investmentsequalityjava.Models.Asset;
import com.juanstudy.investmentsequalityjava.databinding.AdapterAssetsBinding;

import java.util.ArrayList;
import java.util.List;

public class AssetsAdapter extends RecyclerView.Adapter<AssetsAdapter.ViewHolder> {

    private List<Asset> assets;

    public AssetsAdapter() {
        assets = new ArrayList<>();
    }

    @Override
    public AssetsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterAssetsBinding binding = AdapterAssetsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Asset dataModel = assets.get(position);
        holder.bind(dataModel);
//        holder.binding.setItemClickListener(this);
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return assets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public AdapterAssetsBinding binding;

        public ViewHolder(AdapterAssetsBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.binding = itemRowBinding;
        }

        public void bind(Asset asset) {
            binding.tvAssetName.setText(asset.getTag());
            binding.tvAssetDateCom.setText(asset.getId() + "/12");
            binding.tvAssetPercent.setText("R$ " + asset.getPrice().toString());
//            binding.setVariable(BR.model, obj);
//            binding.executePendingBindings();
        }
    }

}
