package com.example.aws.amanda.DataContext.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.aws.amanda.DataContext.Entities.SalidasPresupuesto;

import java.util.List;

@Dao
public interface SalidasPresupuestoDao {

    @Insert
    void insert(SalidasPresupuesto salidasPresupuesto);

    @Query("DELETE FROM SalidasPresupuesto")
    void deleteAll();

    @Query("SELECT * FROM SalidasPresupuesto")
    LiveData<List<SalidasPresupuesto>> getAll();
}
