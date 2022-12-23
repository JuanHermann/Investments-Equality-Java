package com.juanstudy.investmentsequalityjava;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.juanstudy.investmentsequalityjava.Models.Asset;
import com.juanstudy.investmentsequalityjava.ViewModels.MainViewModel;
import com.juanstudy.investmentsequalityjava.databinding.FragmentDialogAssetBinding;


public class DialogAssetFragment extends Fragment {
    private FragmentDialogAssetBinding binding;
    private MainViewModel viewModel;

    public DialogAssetFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDialogAssetBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.etAssetTag.requestFocus();

        setOnClick();
    }

    private void setOnClick() {
        binding.buttonCancel.setOnClickListener(view -> dismiss());
        binding.constraintParent.setOnClickListener(view -> dismiss());
        binding.etAssetTag.addTextChangedListener(getTextWatcher());
        binding.buttonSave.setOnClickListener(view -> {
            viewModel.insert(new Asset(binding.etAssetTag.getText().toString()));
            dismiss();
        });
    }

    private void dismiss() {
        requireActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }

    private TextWatcher getTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 1 || charSequence.length() > 6) {
                    binding.buttonSave.setEnabled(false);
                } else {
                    binding.buttonSave.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }


}

