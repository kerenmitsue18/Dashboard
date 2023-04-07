package com.lostsys.data.Service.api;
import java.util.List;
import com.lostsys.data.Model.Carga;
import com.lostsys.data.Reposity.CargaReposity;
import org.springframework.stereotype.Service;

@Service
public class CargaServiceAPI {
    private final CargaReposity cargareposity;

    public CargaServiceAPI(CargaReposity cargareposity) { this.cargareposity = cargareposity; }

    public Carga getCargaById(int id_carga){ return this.cargareposity.getCargaById(id_carga); }
}