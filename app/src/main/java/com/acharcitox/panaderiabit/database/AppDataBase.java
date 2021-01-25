package com.acharcitox.panaderiabit.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.acharcitox.panaderiabit.entities.Panificado;
import com.acharcitox.panaderiabit.daos.PanificadoDao;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities =  {Panificado.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {
    public abstract PanificadoDao panificadoDao();

    private  static volatile AppDataBase instance;

    public static final ExecutorService databasewriteExecutor = Executors.newFixedThreadPool(4);

    public static AppDataBase getInstance(final Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "panaderia")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
