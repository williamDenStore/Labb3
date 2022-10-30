package com.william_k.labb3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Circle extends Shape{
    int xCenter;
    int yCenter;
    public Circle(int x, int y, Color color, int size) {
        this.x = x;
        this.y = y;
        xCenter = x-size/2;
        yCenter = y-size/2;
        this.color = Objects.requireNonNullElse(color, Color.BLACK);
        this.size = size;
    }
    public void updatePos(){
        xCenter = x-size/2;
        yCenter = y-size/2;
    }
    public void draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(color);
        graphicsContext.fillOval(xCenter,yCenter,size,size);
    }
    public boolean pointInside(int xClick, int yClick){

        int radius = size/2;
        return Math.pow((xClick-(x)),2) + Math.pow((yClick-(y)),2) < Math.pow((radius),2);
    }

}
