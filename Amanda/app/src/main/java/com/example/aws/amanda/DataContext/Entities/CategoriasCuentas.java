package com.example.aws.amanda.DataContext.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "CategoriasCuentas")
public class CategoriasCuentas {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "IdCategoriasCuentas")
    private Integer _idCategoriasCuentas;

    @NonNull
    @ColumnInfo(name = "Name")
    private String _name;


    public CategoriasCuentas(@NonNull String name) {
        _name = name;
    }

    public void setIdCategoriasCuentas(@NonNull Integer _idCategoriasCuentas) {
        this._idCategoriasCuentas = _idCategoriasCuentas;
    }

    @NonNull
    public Integer getIdCategoria() {
        return _idCategoriasCuentas;
    }

    @NonNull
    public String getName() {
        return _name;
    }

}
