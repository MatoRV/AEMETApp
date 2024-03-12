package com.example.aplicacionaemet.Controller;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aplicacionaemet.Model.Tiempo;

import java.util.List;

public class TiempoListViewModel extends ViewModel {
    private MutableLiveData<List<Tiempo>> listaTiempo;
    public LiveData<List<Tiempo>> getTiempos() {
        if (listaTiempo == null) {
            listaTiempo = new MutableLiveData<>();
        }
        //loadTiempo();
        return listaTiempo;
    }

    public void loadTiempo(String enlace) {
        Log.d("ViewModel", "Enlace viewmodel: " +enlace);
        if (enlace != null) {
            MainController.getSingleton().requestTiempoData(enlace, this);
            listaTiempo.postValue(MainController.getSingleton().getDataRequested());
        }
    }

    public void setData(List<Tiempo> list) {
        listaTiempo.postValue(list);
    }

    public void linkAEMET(String municipio) {
        MainController.getSingleton().requestDataFromHttp(municipio,this);
    }
}
