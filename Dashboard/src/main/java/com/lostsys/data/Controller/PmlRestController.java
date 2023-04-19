package com.lostsys.data.Controller;

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

}
