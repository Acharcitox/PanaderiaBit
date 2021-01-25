package com.acharcitox.panaderiabit.models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.acharcitox.panaderiabit.entities.Panificado;
import com.acharcitox.panaderiabit.repositories.PanificadoRepository;

import java.util.List;

public class PanificadoViewModel extends AndroidViewModel {

    private PanificadoRepository panificadoRepository;
    private final LiveData<List<Panificado>> panificados;

    public PanificadoViewModel(Application application) {
        super(application);
        panificadoRepository = new PanificadoRepository(application);
        panificados = panificadoRepository.getPanificados();
    }

    public LiveData<List<Panificado>> getPanificados() {
        return panificados;
    }

    public void insert(Panificado panificado) {
        panificadoRepository.insert(panificado);
    }
}
