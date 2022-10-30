package com.william_k.labb3;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShapesModelTest {
    @Test
    void CheckIfCircleIsInsideCoordinates() {
        Circle c = new Circle(50,50,Color.AQUA,50);
        assertTrue(c.pointInside(33,33));
    }
    @Test
    void CheckIfSquareIsInsideCoordinates() {
        Square c = new Square(50,50,Color.AQUA,50);
        assertTrue(c.pointInside(25,25));
    }
    @Test
    void removeLast() {
        ShapesModel shapesModel = new ShapesModel();
        shapesModel.getShapes().add(new Square(100,100,Color.AQUA,50));
        shapesModel.getShapes().add(new Square(10,10,Color.AQUA,50));
        shapesModel.getShapes().add(new Square(500,500,Color.AQUA,100));
        shapesModel.removeLastShape();

        assertEquals(2, shapesModel.getShapes().size());
        assertEquals(new Square(100,100,Color.AQUA,50).toString(),shapesModel.getShapes().get(0).toString());
        assertEquals(new Square(10,10,Color.AQUA,50).toString(),shapesModel.getShapes().get(1).toString());
    }
}