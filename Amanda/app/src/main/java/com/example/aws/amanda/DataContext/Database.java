package com.example.aws.amanda.DataContext;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.aws.amanda.DataContext.Dao.CategoriaEntradasDao;
import com.example.aws.amanda.DataContext.Dao.CategoriaSalidasDao;
import com.example.aws.amanda.DataContext.Dao.CategoriasCuentasDao;
import com.example.aws.amanda.DataContext.Dao.CuentasDao;
import com.example.aws.amanda.DataContext.Dao.EntradasDao;
import com.example.aws.amanda.DataContext.Dao.PresupuestosDao;
import com.example.aws.amanda.DataContext.Dao.SalidasDao;
import com.example.aws.amanda.DataContext.Dao.SalidasPresupuestoDao;
import com.example.aws.amanda.DataContext.Entities.CategoriaEntradas;
import com.example.aws.amanda.DataContext.Entities.CategoriaSalidas;
import com.example.aws.amanda.DataContext.Entities.CategoriasCuentas;
import com.example.aws.amanda.DataContext.Entities.Cuentas;
import com.example.aws.amanda.DataContext.Entities.Entradas;
import com.example.aws.amanda.DataContext.Entities.Presupuestos;
import com.example.aws.amanda.DataContext.Entities.Salidas;
import com.example.aws.amanda.DataContext.Entities.SalidasPresupuesto;

@android.arch.persistence.room.Database(entities = {CategoriaEntradas.class, CategoriaSalidas.class, CategoriasCuentas.class, Cuentas.class, Entradas.class, Presupuestos.class, Salidas.class, SalidasPresupuesto.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract CategoriasCuentasDao categoriasCuentasDao();
    public abstract CategoriaEntradasDao categoriaEntradasDao();
    public abstract CategoriaSalidasDao categoriaSalidasDao();
    public abstract CuentasDao cuentasDao();
    public abstract EntradasDao entradasDao();
    public abstract PresupuestosDao presupuestosDao();
    public abstract SalidasDao salidasDao();
    public abstract SalidasPresupuestoDao salidasPresupuestoDao();

    private static volatile Database INSTANCE;

    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "Database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
