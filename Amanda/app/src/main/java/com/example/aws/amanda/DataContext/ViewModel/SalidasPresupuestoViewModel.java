package com.example.aws.amanda.DataContext.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.aws.amanda.DataContext.Entities.SalidasPresupuesto;
import com.example.aws.amanda.DataContext.Repositories.SalidasPresupuestoRepository;

import java.util.List;

public class SalidasPresupuestoViewModel extends AndroidViewModel {

    private SalidasPresupuestoRepository repository;

    private LiveData<List<SalidasPresupuesto>> listLiveData;

    public SalidasPresupuestoViewModel (Application application) {
        super(application);
        repository = new SalidasPresupuestoRepository(application);
        listLiveData = repository.getAll();
    }

    public LiveData<List<SalidasPresupuesto>> getAll() { return listLiveData; }

    public void insert(SalidasPresupuesto salidasPresupuesto) { repository.insert(salidasPresupuesto); }

}
