package com.example.aws.amanda.DataContext.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.aws.amanda.DataContext.Entities.Salidas;

import java.util.List;

@Dao
public interface SalidasDao {

    @Insert
    void insert(Salidas salidas);

    @Query("DELETE FROM Salidas")
    void deleteAll();

    @Query("SELECT * FROM Salidas")
    LiveData<List<Salidas>> getAll();
}
