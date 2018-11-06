package com.example.aws.amanda.DataContext.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "CategoriaSalidas")
public class CategoriaSalidas {


    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "IdCategoriaSalidas")
    private Integer _idCategoriaSalidas;

    @NonNull
    @ColumnInfo(name = "Name")
    private String _name;


    public CategoriaSalidas(@NonNull String name) {
        _name = name;
    }

    public void set_idCategoriaSalidas(@NonNull Integer _idCategoriaSalidas) {
        this._idCategoriaSalidas = _idCategoriaSalidas;
    }

    @NonNull
    public Integer getIdCategoria() {
        return _idCategoriaSalidas;
    }

    @NonNull
    public String getName() {
        return _name;
    }

}
