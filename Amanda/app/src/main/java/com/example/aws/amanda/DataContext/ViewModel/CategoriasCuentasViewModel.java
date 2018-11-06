package com.example.aws.amanda.DataContext.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.aws.amanda.DataContext.Entities.CategoriasCuentas;
import com.example.aws.amanda.DataContext.Repositories.CategoriasCuentasRepository;

import java.util.List;

public class CategoriasCuentasViewModel extends AndroidViewModel {

    private CategoriasCuentasRepository repository;

    private LiveData<List<CategoriasCuentas>> listLiveData;

    public CategoriasCuentasViewModel (Application application) {
        super(application);
        repository = new CategoriasCuentasRepository(application);
        listLiveData = repository.getAll();
    }

    public LiveData<List<CategoriasCuentas>> getAll() { return listLiveData; }

    public void insert(CategoriasCuentas categoriasCuentas) { repository.insert(categoriasCuentas); }
}