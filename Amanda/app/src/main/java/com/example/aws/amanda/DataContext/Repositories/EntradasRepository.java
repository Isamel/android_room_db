package com.example.aws.amanda.DataContext.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.aws.amanda.DataContext.Dao.EntradasDao;
import com.example.aws.amanda.DataContext.Database;
import com.example.aws.amanda.DataContext.Entities.Entradas;

import java.util.List;

public class EntradasRepository {

    private EntradasDao entradasDao;
    private LiveData<List<Entradas>> listLiveData;

    public EntradasRepository(Application application) {
        Database db = Database.getDatabase(application);
        entradasDao = db.entradasDao();
        listLiveData = entradasDao.getAll();
    }

    public LiveData<List<Entradas>> getAll() {
        return listLiveData;
    }


    public void insert (Entradas entradas) {
        new EntradasRepository.insertAsyncTask(entradasDao).execute(entradas);
    }

    private static class insertAsyncTask extends AsyncTask<Entradas, Void, Void> {

        private EntradasDao cuentasDao;

        insertAsyncTask(EntradasDao dao) {
            cuentasDao = dao;
        }

        @Override
        protected Void doInBackground(final Entradas... params) {
            cuentasDao.insert(params[0]);
            return null;
        }
    }
}
