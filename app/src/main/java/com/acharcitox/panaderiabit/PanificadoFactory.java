package com.acharcitox.panaderiabit;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.acharcitox.panaderiabit.models.PanificadoViewModel;

public class PanificadoFactory extends ViewModelProvider.NewInstanceFactory {

    @NonNull
    private final Application application;

    public  PanificadoFactory (@NonNull Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass == PanificadoViewModel.class) {
            return (T) new PanificadoViewModel(application);
        }
        return null;
    }
}
