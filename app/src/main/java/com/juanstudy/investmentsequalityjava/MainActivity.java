package com.juanstudy.investmentsequalityjava;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.juanstudy.investmentsequalityjava.ViewModels.MainViewModel;
import com.juanstudy.investmentsequalityjava.adapter.AssetsAdapter;
import com.juanstudy.investmentsequalityjava.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivity;
    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private AssetsAdapter adapter;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = this;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        setOnClick();
        setAdapter();
        setViewModel();

        viewModel.getPapersInfo(null);
    }

    private void setAdapter() {
        adapter = new AssetsAdapter();
        binding.listAssets.setAdapter(adapter);

    }

    private void setViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.listAssets.setLayoutManager(new LinearLayoutManager(this));
        viewModel.getAssets().observe(this, assets -> {
            adapter.setAssets(assets);
            binding.listAssets.scrollToPosition(adapter.getItemCount());

//            adapter.notifyDataSetChanged();
        });

//        viewModel.loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void setOnClick() {
        binding.fab.setOnClickListener(view -> {

            getSupportFragmentManager().beginTransaction().add(binding.fragmentContainer.getId(), new DialogAssetFragment()).commit();

        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_delete_all) {
            viewModel.deleteAll();
            return true;
        } else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        mainActivity = this;
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        if (fragmentList.size() == 0) {
            super.onBackPressed();
        } else {
            for (Fragment frag : fragmentList) {
                getSupportFragmentManager().beginTransaction().remove(frag).commit();
            }
        }

    }
}