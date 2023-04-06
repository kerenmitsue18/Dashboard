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
        return nodoServiceAPI.getNodos();
    }

    @GetMapping(value = "/selected_sistema/{id_sistema}")
    public List<Nodo> getNodoBySistema(@PathVariable int id_sistema){
        return nodoServiceAPI.getNodosBySistema(id_sistema);
    }

}
