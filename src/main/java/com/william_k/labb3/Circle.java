package com.william_k.labb3;

import javafx.scene.paint.Color;

public class Circle extends Shape{
    public Circle(int x, int y, Color color, int size) {
        this.x = x-size/2;
        this.y = y-size/2;
        if (color!=null)
            this.color = color;
        else
            this.color = Color.BLACK;
        this.size = size;
    }

}
