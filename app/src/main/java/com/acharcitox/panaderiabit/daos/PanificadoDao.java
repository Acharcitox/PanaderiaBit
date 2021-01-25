package com.acharcitox.panaderiabit.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.acharcitox.panaderiabit.entities.Panificado;

import java.util.List;

@Dao
public interface PanificadoDao {

    @Query("SELECT * FROM panificado")
    LiveData<List<Panificado>> getAll();

    @Insert
    void insert(Panificado panificado);

    @Update
    void  update(Panificado panificado);

    @Delete
    void delete(Panificado panificado);

    @Query("SELECT * FROM panificado where nombre like :nombre")
    Panificado findByNombre(String nombre);

    @Query("SELECT * FROM panificado where id = :id")
    Panificado findById(int id);
}
