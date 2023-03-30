package com.lostsys.data.commons;

import com.lostsys.data.Model.Sistema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl <T,ID extends Serializable> implements GenericServiceAPI<T,ID> {

    @Override
    public List<T> getAll() {
        List<T> returnList = new ArrayList<>();
        getDao().findAll().forEach(obj -> returnList.add(obj));
        return returnList;
    }

    @Override
    public T get(ID id){
        Optional<T> obj = getDao().findById(id);
        if(obj.isPresent()){
            return obj.get();
        }
        return null;
    }

    public abstract CrudRepository<T,ID> getDao();
}
