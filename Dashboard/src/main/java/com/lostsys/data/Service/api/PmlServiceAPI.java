package com.lostsys.data.Service.api;
import com.lostsys.data.Model.PML;
import com.lostsys.data.Reposity.PmlReposity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PmlServiceAPI {
    private final PmlReposity pmlReposity;


    public PmlServiceAPI(PmlReposity pmlReposity) { this.pmlReposity = pmlReposity;  }
    public PML getPromedios(int id_nodo){
        List<Object[]> list = pmlReposity.getPromedio(id_nodo);
        PML pml = new PML();
        list.stream().forEach( (record) -> {

            pml.setPrecio_marginal((Double) record[0]);
                    pml.setComp_energia((Double) record[1]);
                    pml.setComp_perdidas((Double) record[2]);
                    pml.setComp_congestion( (Double) record[3]);
                });
        return pml;
    }
    /*
    public List<Date> getFechas(){
        List<Date> fechas = new ArrayList<>();
        List<Object[]> list = pmlReposity.getFechas();
        list.stream().forEach( (record) -> {
            fechas.add((Date) record[0]);
            fechas.add((Date) record[1]);
        });
        return fechas;
    }
    */
    public List<Double> getAllPromByFechas(){
        List<Double> promedios = new ArrayList<>();
        List<Object[]> list = pmlReposity.getAllPromByFechas();
        list.stream().forEach( (record) -> { promedios.add((Double) record[0]); });
        return promedios;
    }


    public List<Double> getPromByNodo(int idnodo, String minFecha, String maxFecha){
        List<Double> promedios = new ArrayList<>();
        List<Object[]> list = pmlReposity.getPromByNodo(idnodo, minFecha,maxFecha);
        list.stream().forEach( (record) -> { promedios.add((Double) record[0]);  });
        return promedios;
    }

    public List<Double> getAllPromByFechas(String minFecha, String maxFecha){
        List<Double> promedios = new ArrayList<>();
        List<Object[]> list = pmlReposity.getAllPromByFechas(minFecha,maxFecha);
        list.stream().forEach( (record) -> { promedios.add((Double) record[0]);  });
        return promedios;
    }



}
