package com.william_k.labb3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Square extends Shape{
    int xCenter;
    int yCenter;
    public Square(int x, int y, Color color, int size) {
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
    public boolean pointInside(int xClick, int yClick){
        return xClick <= xCenter+size && xClick >= xCenter && yClick <= yCenter+size && yClick >= yCenter;
    }
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(color);
        graphicsContext.fillRect(xCenter, yCenter, size, size);
    }
    public String convertToSvg(){
        return "\t<rect width=\""+size+"\" height=\""+size+"\" x=\""+x+"\" y=\""+y+"\" fill=\"#"+formatColor()+"\"/>";
    }
}
