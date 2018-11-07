package com.example.aws.amanda.DataContext.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.aws.amanda.DataContext.Entities.Cuentas;
import com.example.aws.amanda.DataContext.Repositories.CuentasRepository;

import java.util.List;

public class CuentasViewModel extends AndroidViewModel {

    private CuentasRepository repository;

    private LiveData<List<Cuentas>> listLiveData;

    public CuentasViewModel (Application application) {
        super(application);
        repository = new CuentasRepository(application);
        listLiveData = repository.getAll();
    }

    public LiveData<List<Cuentas>> getAll() { return listLiveData; }

    public void insert(Cuentas cuentas) { repository.insert(cuentas); }

}
