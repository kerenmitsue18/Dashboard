package com.lostsys.data.Reposity;

import com.lostsys.data.Model.Fechas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("FechasRepo")
public interface FechasRepository extends JpaRepository<Fechas, Long> {

}
