package com.example.aws.amanda.DataContext.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "Entradas")
public class Entradas {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "IdCuenta")
    private Integer _idEntrada;

    @NonNull
    @ColumnInfo(name = "Descripcion")
    private String _descripcion;

    @NonNull
    @ColumnInfo(name = "Saldo")
    private Double _saldo;

    @NonNull
    @ColumnInfo(name = "Fecha")
    private Date _fecha;

    @NonNull
    @ColumnInfo(name = "IdCategoria")
    private Integer _idCategoria;

    @NonNull
    @ColumnInfo(name = "IdCuenta")
    private Integer _idCuenta;


    public Entradas(@NonNull String descripcion, @NonNull Double saldo, @NonNull Date fecha, @NonNull Integer idCategoria, @NonNull Integer idCuenta) {
        _descripcion = descripcion;
        _saldo = saldo;
        _fecha = fecha;
        _idCategoria = idCategoria;
        _idCuenta = idCuenta;
    }

    public void setIdEntrada(@NonNull Integer _idEntrada) {
        this._idEntrada = _idEntrada;
    }

    @NonNull
    public Integer getIdEntrada() {
        return _idEntrada;
    }

    @NonNull
    public String getDescripcion() {
        return _descripcion;
    }

    @NonNull
    public Double getSaldo() {
        return _saldo;
    }

    @NonNull
    public Date getFecha() {
        return _fecha;
    }

    @NonNull
    public Integer getIdCategoria() {
        return _idCategoria;
    }

    @NonNull
    public Integer getIdCuenta() {
        return _idCuenta;
    }

}
