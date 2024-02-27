package cz.upce.fei.nnpia.cviceni.service;

import cz.upce.fei.nnpia.cviceni.model.Camera;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CameraService implements ServiceI<Camera> {
    private final Map<Integer, Camera> objectMap = new HashMap<>();

    public CameraService() {
        objectMap.put(1, new Camera(1, "Nikon", 2020));
        objectMap.put(2, new Camera(2, "Canon", 2021));
        objectMap.put(3, new Camera(3, "Sony", 2023));
    }

    @Override
    public List<Camera> getAllObjects() {
        return new ArrayList<>(objectMap.values());
    }

    @Override
    public Camera getObjectById(int id) {
        return objectMap.get(id);
    }
}
