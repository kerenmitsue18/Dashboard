package com.lostsys.data.commons;

import com.lostsys.data.Model.Sistema;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI <T,ID extends Serializable> {
    List<T> getAll();
    T get(ID id);
}
