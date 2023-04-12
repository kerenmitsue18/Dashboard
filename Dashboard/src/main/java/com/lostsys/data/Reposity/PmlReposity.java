package com.lostsys.data.Reposity;

import com.lostsys.data.Model.PML;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("PmlRepo")
public interface PmlReposity extends JpaRepository<PML, Long> {

    @Query(value = "SELECT id_nodo, ROUND(AVG(precio_marginal),2) AS precio_marginal , " +
            "ROUND(AVG(comp_energia),2) AS comp_energia, " +
            "ROUND(AVG(comp_perdidas),2) AS comp_perdidas, " +
            "ROUND(AVG(comp_congestion),2) AS comp_congestion " +
            "FROM pml WHERE id_nodo=?1", nativeQuery = true)
    public PML getPromedio(int id_nodo);
}
