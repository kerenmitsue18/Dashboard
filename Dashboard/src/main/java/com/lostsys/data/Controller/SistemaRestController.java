package com.lostsys.data.Controller;

import java.util.List;
import com.lostsys.data.Model.Sistema;
import com.lostsys.data.Service.api.SistemaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class SistemaRestController {
    @Autowired
    private SistemaServiceAPI sistemaServiceAPI;

    @GetMapping(value = "/sistema")
    public List<Sistema> getAll() {
        return sistemaServiceAPI.getSistemas();
    }

}
