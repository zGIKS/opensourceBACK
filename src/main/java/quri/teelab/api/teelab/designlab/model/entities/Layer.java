package quri.teelab.api.teelab.designlab.model.entities;

import quri.teelab.api.teelab.designlab.model.valueobjects.LayerId;
import quri.teelab.api.teelab.designlab.model.valueobjects.LayerType;

import java.util.Date;

public class Layer {
    private LayerId id;

    private int x;
    private int y;
    private int z;

    private Float opacity;
    private boolean isVisible;

    private LayerType type;
    private Date createdAt;
    private Date updatedAt;

}
