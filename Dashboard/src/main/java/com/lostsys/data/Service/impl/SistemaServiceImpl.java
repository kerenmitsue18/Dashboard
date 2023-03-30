package com.lostsys.data.Service.impl;

import com.lostsys.data.Model.Sistema;
import com.lostsys.data.Service.api.SistemaServiceAPI;
import com.lostsys.data.commons.GenericServiceImpl;
import com.lostsys.data.dao.api.SistemaDaoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SistemaServiceImpl extends GenericServiceImpl<Sistema, Integer> implements SistemaServiceAPI {

    @Autowired
    private SistemaDaoAPI sistemaDaoAPI;

    @Override
    public CrudRepository<Sistema, Integer> getDao() {
        return sistemaDaoAPI;
    }

}
