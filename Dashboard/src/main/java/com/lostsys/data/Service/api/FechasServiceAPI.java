package com.lostsys.data.Service.api;

import com.lostsys.data.Model.Fechas;
import com.lostsys.data.Reposity.FechasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FechasServiceAPI {

    private final FechasRepository fechasRepository;


    public FechasServiceAPI(FechasRepository fechasRepository) {
        this.fechasRepository = fechasRepository;
    }

    public List<Fechas> getFechas(){
        return fechasRepository.findAll();
    }
}
