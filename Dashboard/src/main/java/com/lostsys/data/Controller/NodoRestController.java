package com.lostsys.data.Controller;

import com.lostsys.data.Model.Nodo;
import com.lostsys.data.Service.api.NodoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class NodoRestController {

    @Autowired
    private NodoServiceAPI nodoServiceAPI;

    @GetMapping(value = "/nodos")
    public List<Nodo> getAll() {
        return nodoServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Nodo find(@PathVariable Integer id) {
        return nodoServiceAPI.get(id);
    }



}
