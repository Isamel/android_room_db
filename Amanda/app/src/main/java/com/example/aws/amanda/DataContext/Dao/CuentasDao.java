package com.example.aws.amanda.DataContext.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.aws.amanda.DataContext.Entities.Cuentas;

import java.util.List;

@Dao
public interface CuentasDao {

    @Insert
    void insert(Cuentas cuentas);

    @Query("DELETE FROM Cuentas")
    void deleteAll();

    @Query("SELECT * FROM Cuentas")
    LiveData<List<Cuentas>> getAll();
}
