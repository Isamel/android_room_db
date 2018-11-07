package com.example.aws.amanda.DataContext.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.aws.amanda.DataContext.Entities.CategoriaSalidas;
import com.example.aws.amanda.DataContext.Repositories.CategoriaSalidasRepository;

import java.util.List;

public class CategoriaSalidasViewModel   extends AndroidViewModel {

    private CategoriaSalidasRepository repository;

    private LiveData<List<CategoriaSalidas>> listLiveData;

    public CategoriaSalidasViewModel (Application application) {
        super(application);
        repository = new CategoriaSalidasRepository(application);
        listLiveData = repository.getAll();
    }

    public LiveData<List<CategoriaSalidas>> getAll() { return listLiveData; }

    public void insert(CategoriaSalidas categoriaSalidas) { repository.insert(categoriaSalidas); }

}
