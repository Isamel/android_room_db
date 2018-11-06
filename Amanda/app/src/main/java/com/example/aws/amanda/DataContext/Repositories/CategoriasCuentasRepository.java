package com.example.aws.amanda.DataContext.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.aws.amanda.DataContext.Dao.CategoriasCuentasDao;
import com.example.aws.amanda.DataContext.Database;
import com.example.aws.amanda.DataContext.Entities.CategoriasCuentas;

import java.util.List;

public class CategoriasCuentasRepository {

    private CategoriasCuentasDao categoriasCuentasDao;
    private LiveData<List<CategoriasCuentas>> listLiveData;

    public CategoriasCuentasRepository(Application application) {
        Database db = Database.getDatabase(application);
        categoriasCuentasDao = db.categoriasCuentasDao();
        listLiveData = categoriasCuentasDao.getAll();
    }

    public LiveData<List<CategoriasCuentas>> getAll() {
        return listLiveData;
    }


    public void insert (CategoriasCuentas categoriasCuentas) {
        new insertAsyncTask(categoriasCuentasDao).execute(categoriasCuentas);
    }

    private static class insertAsyncTask extends AsyncTask<CategoriasCuentas, Void, Void> {

        private CategoriasCuentasDao cuentasDao;

        insertAsyncTask(CategoriasCuentasDao dao) {
            cuentasDao = dao;
        }

        @Override
        protected Void doInBackground(final CategoriasCuentas... params) {
            cuentasDao.insert(params[0]);
            return null;
        }
    }
}
