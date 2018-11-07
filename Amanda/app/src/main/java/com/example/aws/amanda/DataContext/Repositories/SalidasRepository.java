package com.example.aws.amanda.DataContext.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.aws.amanda.DataContext.Dao.SalidasDao;
import com.example.aws.amanda.DataContext.Database;
import com.example.aws.amanda.DataContext.Entities.Salidas;

import java.util.List;

public class SalidasRepository {

    private SalidasDao salidasDao;
    private LiveData<List<Salidas>> listLiveData;

    public SalidasRepository(Application application) {
        Database db = Database.getDatabase(application);
        salidasDao = db.salidasDao();
        listLiveData = salidasDao.getAll();
    }

    public LiveData<List<Salidas>> getAll() {
        return listLiveData;
    }


    public void insert (Salidas salidas) {
        new SalidasRepository.insertAsyncTask(salidasDao).execute(salidas);
    }

    private static class insertAsyncTask extends AsyncTask<Salidas, Void, Void> {

        private SalidasDao salidasDao1;

        insertAsyncTask(SalidasDao dao) {
            salidasDao1 = dao;
        }

        @Override
        protected Void doInBackground(final Salidas... params) {
            salidasDao1.insert(params[0]);
            return null;
        }
    }
}
