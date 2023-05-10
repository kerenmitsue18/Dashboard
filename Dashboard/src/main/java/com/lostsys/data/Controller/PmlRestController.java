package com.lostsys.data.Controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lostsys.data.Model.PML;
import com.lostsys.data.Service.api.PmlServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class PmlRestController {

    @Autowired
    private PmlServiceAPI pmlServiceAPI;

    @GetMapping(value = "/promedios/{id_nodo}")
    public PML getPromedios(@PathVariable int id_nodo){
        return pmlServiceAPI.getPromedios(id_nodo);
    }

    @GetMapping(value= "/maxFecha")
    public Date getMaxFecha(){ return pmlServiceAPI.getMaxFecha();}

    @GetMapping(value= "/minFecha")
    public Date getMinFecha(){ return pmlServiceAPI.getMinFecha();}

    @GetMapping("/{minFecha}/fecha/{maxFecha}")
    public List<Double> getAllPromByFechas(@PathVariable String minFecha, @PathVariable String maxFecha){
        return pmlServiceAPI.getAllPromByFechas(minFecha,maxFecha);
    }

    @PatchMapping("/graph1_prom/{id_nodo}")
    public List<Double> getPromByNodo(@PathVariable int id_nodo){
        return pmlServiceAPI.getPromByNodo(id_nodo, "2022-01-01", "2023-03-14");
    }
}
