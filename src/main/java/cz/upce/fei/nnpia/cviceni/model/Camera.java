package cz.upce.fei.nnpia.cviceni.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Camera {
    private final int id;
    private final String name;
    private final int year;
}
