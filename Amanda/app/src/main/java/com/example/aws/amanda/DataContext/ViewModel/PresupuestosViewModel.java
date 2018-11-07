package com.example.aws.amanda.DataContext.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.aws.amanda.DataContext.Entities.Presupuestos;
import com.example.aws.amanda.DataContext.Repositories.PresupuestosRepository;

import java.util.List;

public class PresupuestosViewModel extends AndroidViewModel {

    private PresupuestosRepository repository;

    private LiveData<List<Presupuestos>> listLiveData;

    public PresupuestosViewModel (Application application) {
        super(application);
        repository = new PresupuestosRepository(application);
        listLiveData = repository.getAll();
    }

    public LiveData<List<Presupuestos>> getAll() { return listLiveData; }

    public void insert(Presupuestos presupuestos) { repository.insert(presupuestos); }

}
