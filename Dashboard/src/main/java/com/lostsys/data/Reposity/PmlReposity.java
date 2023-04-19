package com.lostsys.data.Reposity;

import com.lostsys.data.Model.PML;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository("PmlRepo")
public interface PmlReposity extends JpaRepository<PML, Long> {


    @Query(value = "SELECT ROUND(AVG(precio_marginal),2) AS precio_marginal, ROUND(AVG(comp_energia),2) AS comp_energia, ROUND(AVG(comp_perdidas),2) AS comp_perdidas, ROUND(AVG(comp_congestion),2) AS comp_congestion FROM pml WHERE id_nodo=?1",nativeQuery = true)
    public List<Object[]> getPromedio(int id_nodo);
}
