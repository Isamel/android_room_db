package com.example.aws.amanda.DataContext.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.aws.amanda.DataContext.Entities.Salidas;
import com.example.aws.amanda.DataContext.Repositories.SalidasRepository;

import java.util.List;

public class SalidasViewModel extends AndroidViewModel {

    private SalidasRepository repository;

    private LiveData<List<Salidas>> listLiveData;

    public SalidasViewModel (Application application) {
        super(application);
        repository = new SalidasRepository(application);
        listLiveData = repository.getAll();
    }

    public LiveData<List<Salidas>> getAll() { return listLiveData; }

    public void insert(Salidas salidas) { repository.insert(salidas); }

}
