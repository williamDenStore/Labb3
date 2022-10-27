package com.william_k.labb3;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ShapesModel {


    ArrayList<Shape> shapes = new ArrayList<>();
    ShapeType shapeType;

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
    public void addShape(Shape shape){
        if(shapeType!=null)
            shapes.add(shape);
    }
    public ArrayList<Shape> getShapes() {
        return shapes;
    }


    public void removeLastShape() {
        if (shapes.size()!=0)
            shapes.remove(shapes.size() - 1);
    }

    public ShapeType getShapeType() {
        return shapeType;
    }
}
