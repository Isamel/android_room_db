package com.example.aws.amanda.DataContext.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "CategoriaEntradas")
public class CategoriaEntradas {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "IdCategoriaEntradas")
    private Integer _idCategoriaEntradas;

    @NonNull
    @ColumnInfo(name = "Name")
    private String _name;


    public CategoriaEntradas(@NonNull String name) {
        _name = name;
    }

    @NonNull
    public Integer getIdCategoria() {
        return _idCategoriaEntradas;
    }

    @NonNull
    public String getName() {
        return _name;
    }
}
