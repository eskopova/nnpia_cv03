package cz.upce.fei.nnpia.cviceni.controllers;

import cz.upce.fei.nnpia.cviceni.model.Camera;
import cz.upce.fei.nnpia.cviceni.service.CameraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CameraController {

    private final CameraService service;

    public CameraController(CameraService service) {
        this.service = service;
    }

    @GetMapping("/cameras")
    public List<Camera> getAllObjects() {
        return service.getAllObjects();
    }

    @GetMapping("/cameras/{id}")
    public ResponseEntity<Camera> getObjectById(@PathVariable int id) {
        Camera camera = service.getObjectById(id);
        if (camera != null) {
            return ResponseEntity.ok(camera);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
