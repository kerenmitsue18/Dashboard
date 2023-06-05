package com.lostsys.data.Controller;

import java.util.Date;
import java.util.List;

import com.lostsys.data.Model.PML;
import com.lostsys.data.Service.api.PmlServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class PmlRestController {

    @Autowired
    private PmlServiceAPI pmlServiceAPI;

    @GetMapping(value = "/promedios/{id_nodo}")
    public PML getPromedios(@PathVariable int id_nodo){
        return pmlServiceAPI.getPromedios(id_nodo);
    }



    @GetMapping(value= "/allPML")
    public List<Double> getAllPromByFechas(){
        return pmlServiceAPI.getAllPromByFechas();
    }

    @RequestMapping(value = "/{minFecha}/fecha/{maxFecha}", method = RequestMethod.GET)
    public List<Double> getAllPromByFechas( @PathVariable String minFecha, @PathVariable String maxFecha){
        return pmlServiceAPI.getAllPromByFechas(minFecha, maxFecha);
    }

    @PatchMapping("/graph1_prom/{id_nodo}")
    public List<Double> getPromByNodo(@PathVariable int id_nodo, @PathVariable String minFecha, @PathVariable String maxFecha){
        return pmlServiceAPI.getPromByNodo(id_nodo, minFecha, maxFecha);
    }
}
