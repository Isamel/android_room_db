package com.example.aws.amanda.DataContext.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.aws.amanda.DataContext.Dao.PresupuestosDao;
import com.example.aws.amanda.DataContext.Database;
import com.example.aws.amanda.DataContext.Entities.Presupuestos;

import java.util.List;

public class PresupuestosRepository {

    private PresupuestosDao presupuestosDao;
    private LiveData<List<Presupuestos>> listLiveData;

    public PresupuestosRepository(Application application) {
        Database db = Database.getDatabase(application);
        presupuestosDao = db.presupuestosDao();
        listLiveData = presupuestosDao.getAll();
    }

    public LiveData<List<Presupuestos>> getAll() {
        return listLiveData;
    }


    public void insert (Presupuestos presupuestos) {
        new PresupuestosRepository.insertAsyncTask(presupuestosDao).execute(presupuestos);
    }

    private static class insertAsyncTask extends AsyncTask<Presupuestos, Void, Void> {

        private PresupuestosDao presupuestosDao1;

        insertAsyncTask(PresupuestosDao dao) {
            presupuestosDao1 = dao;
        }

        @Override
        protected Void doInBackground(final Presupuestos... params) {
            presupuestosDao1.insert(params[0]);
            return null;
        }
    }
}
