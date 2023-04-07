package com.lostsys.data.Reposity;

import com.lostsys.data.Model.Carga;
import com.lostsys.data.Model.Nodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CargaRepo")
public interface CargaReposity extends JpaRepository<Carga,Long> {
    @Query(value = "SELECT * FROM zona_carga WHERE id_carga=?1", nativeQuery = true)
    public Carga getCargaById(int id_carga);

}
