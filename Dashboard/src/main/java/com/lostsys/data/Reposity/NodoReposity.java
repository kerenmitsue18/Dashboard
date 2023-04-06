package com.lostsys.data.Reposity;

import com.lostsys.data.Model.Nodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository("NodoRepo")
public interface NodoReposity extends JpaRepository<Nodo, Long> {

    @Query(value = "SELECT * FROM nodo WHERE id_sistema=?1", nativeQuery = true)
    public  List<Nodo> getNodosBySistema(int id_sistema);
}
