package com.example.aws.amanda.DataContext.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.aws.amanda.DataContext.Entities.Entradas;
import com.example.aws.amanda.DataContext.Repositories.EntradasRepository;

import java.util.List;

public class EntradasViewModel extends AndroidViewModel {

    private EntradasRepository repository;

    private LiveData<List<Entradas>> listLiveData;

    public EntradasViewModel (Application application) {
        super(application);
        repository = new EntradasRepository(application);
        listLiveData = repository.getAll();
    }

    public LiveData<List<Entradas>> getAll() { return listLiveData; }

    public void insert(Entradas entrada) { repository.insert(entrada); }

}
