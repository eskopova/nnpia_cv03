package cz.upce.fei.nnpia.cviceni.service;

import java.util.List;

public interface ServiceI<T> {
    List<T> getAllObjects();
    T getObjectById(int id);
}
