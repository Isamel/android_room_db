package com.example.aws.amanda.DataContext.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.aws.amanda.DataContext.Dao.CategoriaEntradasDao;
import com.example.aws.amanda.DataContext.Database;
import com.example.aws.amanda.DataContext.Entities.CategoriaEntradas;

import java.util.List;

public class CategoriaEntradasRepository {

    private CategoriaEntradasDao categoriaEntradasDao;
    private LiveData<List<CategoriaEntradas>> listLiveData;

    public CategoriaEntradasRepository(Application application) {
        Database db = Database.getDatabase(application);
        categoriaEntradasDao = db.categoriaEntradasDao();
        listLiveData = categoriaEntradasDao.getAll();
    }

    public LiveData<List<CategoriaEntradas>> getAll() {
        return listLiveData;
    }


    public void insert (CategoriaEntradas categoriaEntradas) {
        new CategoriaEntradasRepository.insertAsyncTask(categoriaEntradasDao).execute(categoriaEntradas);
    }

    private static class insertAsyncTask extends AsyncTask<CategoriaEntradas, Void, Void> {

        private CategoriaEntradasDao entradasDao;

        insertAsyncTask(CategoriaEntradasDao dao) {
            entradasDao = dao;
        }

        @Override
        protected Void doInBackground(final CategoriaEntradas... params) {
            entradasDao.insert(params[0]);
            return null;
        }
    }
}
