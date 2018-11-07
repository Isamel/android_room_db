package com.example.aws.amanda.DataContext.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.aws.amanda.DataContext.Dao.SalidasPresupuestoDao;
import com.example.aws.amanda.DataContext.Database;
import com.example.aws.amanda.DataContext.Entities.SalidasPresupuesto;

import java.util.List;

public class SalidasPresupuestoRepository {

    private SalidasPresupuestoDao salidasPresupuestoDao;
    private LiveData<List<SalidasPresupuesto>> listLiveData;

    public SalidasPresupuestoRepository(Application application) {
        Database db = Database.getDatabase(application);
        salidasPresupuestoDao = db.salidasPresupuestoDao();
        listLiveData = salidasPresupuestoDao.getAll();
    }

    public LiveData<List<SalidasPresupuesto>> getAll() {
        return listLiveData;
    }


    public void insert (SalidasPresupuesto salidasPresupuesto) {
        new SalidasPresupuestoRepository.insertAsyncTask(salidasPresupuestoDao).execute(salidasPresupuesto);
    }

    private static class insertAsyncTask extends AsyncTask<SalidasPresupuesto, Void, Void> {

        private SalidasPresupuestoDao salidasPresupuestoDao1;

        insertAsyncTask(SalidasPresupuestoDao dao) {
            salidasPresupuestoDao1 = dao;
        }

        @Override
        protected Void doInBackground(final SalidasPresupuesto... params) {
            salidasPresupuestoDao1.insert(params[0]);
            return null;
        }
    }
}
