package za.ac.cput.service;

import org.springframework.stereotype.Service;

public interface IService <T,ID>{

    T  create(T t);
    T update(T t);
    ID read(ID id);


}
