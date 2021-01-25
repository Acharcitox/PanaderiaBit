package com.acharcitox.panaderiabit;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.acharcitox.panaderiabit.daos.PanificadoDao;
import com.acharcitox.panaderiabit.database.AppDataBase;
import com.acharcitox.panaderiabit.entities.Panificado;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class PanificadoTest {
    private PanificadoDao panificadoDao;
    private AppDataBase appDataBase;

    @Before
    public void createDb(){
        Context context = ApplicationProvider.getApplicationContext();
        appDataBase = Room.inMemoryDatabaseBuilder(context, AppDataBase.class).build();
        panificadoDao = appDataBase.panificadoDao();
    }

    @After
    public void closeDb() throws IOException {
        appDataBase.close();
    }

    @Test
    public void findByNameTest() throws Exception {
        Panificado panificado = new Panificado();
        panificado.setId(1);
        panificado.setNombre("Galleta");

        panificadoDao.insert(panificado);

        Panificado buscado = panificadoDao.findByNombre("Galleta");

        assertTrue( "No encontró la galleta", panificado.getId() == buscado.getId());
    }
}
