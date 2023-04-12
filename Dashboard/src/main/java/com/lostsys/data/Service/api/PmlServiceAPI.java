package com.lostsys.data.Service.api;

import com.lostsys.data.Model.PML;
import com.lostsys.data.Reposity.PmlReposity;
import org.springframework.stereotype.Service;

@Service
public class PmlServiceAPI {

    private final PmlReposity pmlReposity;

    public PmlServiceAPI(PmlReposity pmlReposity) { this.pmlReposity = pmlReposity;  }

    public PML getPromedios(int id_nodo){ return pmlReposity.getPromedio(id_nodo); }
}
