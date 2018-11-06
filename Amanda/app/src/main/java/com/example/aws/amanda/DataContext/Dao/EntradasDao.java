package com.example.aws.amanda.DataContext.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.aws.amanda.DataContext.Entities.Entradas;

import java.util.List;

@Dao
public interface EntradasDao {

    @Insert
    void insert(Entradas entradas);

    @Query("DELETE FROM Entradas")
    void deleteAll();

    @Query("SELECT * FROM Entradas")
    LiveData<List<Entradas>> getAll();
}
