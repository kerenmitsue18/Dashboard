package com.lostsys.data.Reposity;

import com.lostsys.data.Model.PML;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("PmlRepo")
public interface PmlReposity extends JpaRepository<PML, Long> {

    @Query(value = "SELECT ROUND(AVG(precio_marginal),2) AS precio_marginal, ROUND(AVG(comp_energia),2) AS comp_energia, ROUND(AVG(comp_perdidas),2) AS comp_perdidas, ROUND(AVG(comp_congestion),2) AS comp_congestion FROM pml WHERE id_nodo=?1",nativeQuery = true)
    public List<Object[]> getPromedio(int id_nodo);

    @Query(value = "SELECT * FROM vista_allPML", nativeQuery = true)
    public List<Object[]> getAllPromByFechas();

    @Query(value = "SELECT ROUND(AVG(precio_marginal),2) as precio_marginal FROM pml WHERE fecha BETWEEN ?1 AND ?2 GROUP BY hora ", nativeQuery = true)
    public List<Object[]> getAllPromByFechas(String minFecha, String maxFecha);
    @Query(value = "SELECT ROUND(AVG(precio_marginal),2) as precio_marginal FROM pml WHERE idNodo=?1 AND fecha BETWEEN ?2 AND ?3 GROUP BY hora ", nativeQuery = true)
    public List<Object[]> getPromByNodo(int idnodo, String minFecha, String maxFecha);
}
