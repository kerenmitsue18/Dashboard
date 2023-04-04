package com.lostsys.data.Controller;

import com.lostsys.data.Service.api.NodoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class NodoRestController {

    @Autowired
    private NodoServiceAPI nodoServiceApi;

}
