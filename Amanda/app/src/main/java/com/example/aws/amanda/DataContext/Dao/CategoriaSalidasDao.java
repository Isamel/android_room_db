package com.example.aws.amanda.DataContext.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.aws.amanda.DataContext.Entities.CategoriaSalidas;

import java.util.List;

@Dao
public interface CategoriaSalidasDao {

    @Insert
    void insert(CategoriaSalidas categoriaSalidas);

    @Query("DELETE FROM CategoriaSalidas")
    void deleteAll();

    @Query("SELECT * FROM CategoriaSalidas")
    LiveData<List<CategoriaSalidas>> getAll();
}
