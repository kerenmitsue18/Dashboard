package com.lostsys.data.Reposity;

import com.lostsys.data.Model.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("SistemaRepo")
public interface SistemaReposity extends JpaRepository<Sistema, Long> {

}
