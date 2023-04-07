package com.lostsys.data.Controller;

import com.lostsys.data.Model.Carga;
import com.lostsys.data.Service.api.CargaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class CargaRestController {

    @Autowired
    private CargaServiceAPI cargaServiceAPI;

    @GetMapping(value = "/selected_carga/{id_carga}")
    public Carga getCargaBySistema(@PathVariable int id_carga){
        return cargaServiceAPI.getCargaById(id_carga);
    }

}

