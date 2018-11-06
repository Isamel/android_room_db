package com.example.aws.amanda.DataContext.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.aws.amanda.DataContext.Dao.CategoriaSalidasDao;
import com.example.aws.amanda.DataContext.Database;
import com.example.aws.amanda.DataContext.Entities.CategoriaSalidas;

import java.util.List;

public class CategoriaSalidasRepository {

    private CategoriaSalidasDao categoriaSalidasDao;
    private LiveData<List<CategoriaSalidas>> listLiveData;

    public CategoriaSalidasRepository(Application application) {
        Database db = Database.getDatabase(application);
        categoriaSalidasDao = db.categoriaSalidasDao();
        listLiveData = categoriaSalidasDao.getAll();
    }

    public LiveData<List<CategoriaSalidas>> getAll() {
        return listLiveData;
    }


    public void insert (CategoriaSalidas categoriaSalidas) {
        new CategoriaSalidasRepository.insertAsyncTask(categoriaSalidasDao).execute(categoriaSalidas);
    }

    private static class insertAsyncTask extends AsyncTask<CategoriaSalidas, Void, Void> {

        private CategoriaSalidasDao salidasDao;

        insertAsyncTask(CategoriaSalidasDao dao) {
            salidasDao = dao;
        }

        @Override
        protected Void doInBackground(final CategoriaSalidas... params) {
            salidasDao.insert(params[0]);
            return null;
        }
    }
}