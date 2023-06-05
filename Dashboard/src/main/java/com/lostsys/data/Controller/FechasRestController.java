package com.lostsys.data.Controller;

import com.lostsys.data.Model.Fechas;
import com.lostsys.data.Service.api.FechasServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class FechasRestController {
    @Autowired
    private FechasServiceAPI fechasServiceAPI;

    @GetMapping(value= "/get_fechas")
    public List<Fechas> getFechas(){
         return fechasServiceAPI.getFechas();
    }
}
