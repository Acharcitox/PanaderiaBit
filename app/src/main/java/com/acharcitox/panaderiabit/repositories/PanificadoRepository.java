package com.acharcitox.panaderiabit.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.acharcitox.panaderiabit.daos.PanificadoDao;
import com.acharcitox.panaderiabit.database.AppDataBase;
import com.acharcitox.panaderiabit.entities.Panificado;

import java.util.List;

public class PanificadoRepository {
    private PanificadoDao panificadoDao;

    private LiveData<List<Panificado>> panificados;

    public PanificadoRepository(Application application) {
        AppDataBase db = AppDataBase.getInstance(application);
        panificadoDao = db.panificadoDao();
        panificados = panificadoDao.getAll();
    }

    public LiveData<List<Panificado>> getPanificados() {
        return panificados;
    }

    public void insert(final Panificado panificado) {
        AppDataBase.databasewriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                panificadoDao.insert(panificado);
            }
        });
    }
}
