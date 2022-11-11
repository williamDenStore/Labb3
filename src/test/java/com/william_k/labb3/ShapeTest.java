package com.william_k.labb3;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShapeTest {
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
}