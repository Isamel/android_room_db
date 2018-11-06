package com.example.aws.amanda.DataContext.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.aws.amanda.DataContext.Entities.CategoriaEntradas;

import java.util.List;

@Dao
public interface CategoriaEntradasDao {

    @Insert
    void insert(CategoriaEntradas categoriaEntradas);

    @Query("DELETE FROM CategoriaEntradas")
    void deleteAll();

    @Query("SELECT * FROM CategoriaEntradas")
    LiveData<List<CategoriaEntradas>> getAll();
}
