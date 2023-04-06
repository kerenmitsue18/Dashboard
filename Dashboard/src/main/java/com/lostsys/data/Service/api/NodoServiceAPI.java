package com.lostsys.data.Service.api;

import com.lostsys.data.Model.Nodo;

import com.lostsys.data.Reposity.NodoReposity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NodoServiceAPI {


    private final NodoReposity nodoreposity;

    public NodoServiceAPI(NodoReposity nodoreposity) {
        this.nodoreposity = nodoreposity;
    }

    public List<Nodo> getNodos() {
        return nodoreposity.findAll();
    }

    public List<Nodo> getNodosBySistema(int id_sistema){
        return nodoreposity.getNodosBySistema(id_sistema);
    }
}