package com.lostsys.data.Controller;


import com.lostsys.data.Service.api.SistemaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
//@Controller
//@RequestMapping
public class SistemaController {
    @Autowired
    private SistemaServiceAPI sistemaServiceAPI;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> getSistema() {
        return new ResponseEntity<>(sistemaServiceAPI.getAll(), HttpStatus.OK);
        //model.addAttribute("list", sistemaServiceAPI.getAll());
        //Stream.of(sistemaServiceAPI.getAll().toString()).forEach(System.out::println);

    }
}
