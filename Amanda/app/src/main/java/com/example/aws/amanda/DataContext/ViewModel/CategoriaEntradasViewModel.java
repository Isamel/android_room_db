package com.example.aws.amanda.DataContext.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.aws.amanda.DataContext.Entities.CategoriaEntradas;
import com.example.aws.amanda.DataContext.Repositories.CategoriaEntradasRepository;

import java.util.List;

public class CategoriaEntradasViewModel  extends AndroidViewModel {

    private CategoriaEntradasRepository repository;

    private LiveData<List<CategoriaEntradas>> listLiveData;

    public CategoriaEntradasViewModel (Application application) {
        super(application);
        repository = new CategoriaEntradasRepository(application);
        listLiveData = repository.getAll();
    }

    public LiveData<List<CategoriaEntradas>> getAll() { return listLiveData; }

    public void insert(CategoriaEntradas categoriaEntradas) { repository.insert(categoriaEntradas); }

}
