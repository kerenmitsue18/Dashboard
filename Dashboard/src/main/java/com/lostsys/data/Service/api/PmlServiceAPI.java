package com.lostsys.data.Service.api;
import com.lostsys.data.Model.PML;
import com.lostsys.data.Reposity.PmlReposity;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PmlServiceAPI {
    private final PmlReposity pmlReposity;

    public PmlServiceAPI(PmlReposity pmlReposity) { this.pmlReposity = pmlReposity;  }
    public PML getPromedios(int id_nodo){
        List<Object[]> list = pmlReposity.getPromedio(id_nodo);
        PML pml = new PML();
        //este es un nuevo comentario sincronizado v2
        list.stream().forEach( (record) -> {
            pml.setPrecio_marginal((Double) record[0]);
                    pml.setComp_energia((Double) record[1]);
                    pml.setComp_perdidas((Double) record[2]);
                    pml.setComp_congestion( (Double) record[3]);
                });
        return pml;

    }
}
