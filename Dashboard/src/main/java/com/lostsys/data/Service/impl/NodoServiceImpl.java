package com.lostsys.data.Service.impl;

import com.lostsys.data.Model.Nodo;
import com.lostsys.data.Service.api.NodoServiceAPI;
import com.lostsys.data.commons.GenericServiceImpl;
import com.lostsys.data.dao.api.NodoDaoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class NodoServiceImpl extends GenericServiceImpl<Nodo, Integer> implements NodoServiceAPI {

    @Autowired
    private NodoDaoAPI nodoDaoAPI;

    @Override
    public CrudRepository<Nodo, Integer> getDao() {
        return nodoDaoAPI;
    }

}
