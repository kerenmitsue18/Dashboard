package com.lostsys.data.Controller;


import com.lostsys.data.Service.api.NodoServiceAPI;
import com.lostsys.data.Service.api.SistemaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
//@RequestMapping
public class NodoController {
    @Autowired
    private NodoServiceAPI nodoServiceAPI;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> getNodo() {
        return new ResponseEntity<>(nodoServiceAPI.getAll(), HttpStatus.OK);
        //model.addAttribute("list", sistemaServiceAPI.getAll());
        //Stream.of(sistemaServiceAPI.getAll().toString()).forEach(System.out::println);

    }
}
