package com.lostsys.data.Service.api;


import com.lostsys.data.Model.Sistema;
import com.lostsys.data.Reposity.SistemaReposity;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SistemaServiceAPI {


    private final SistemaReposity sistemareposity;

    public SistemaServiceAPI(SistemaReposity sistemareposity) {
        this.sistemareposity = sistemareposity;
    }

    public List<Sistema> getSistemas() {
        return sistemareposity.findAll();
    }


}
