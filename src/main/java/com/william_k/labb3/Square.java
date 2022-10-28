package com.william_k.labb3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape{
    public Square(int x, int y, Color color, int size) {
        this.x = x-size/2;
        this.y = y-size/2;
        if (color!=null)
            this.color = color;
        else
            this.color = Color.BLACK;
        this.size = size;
    }
    public void withinArea(){
    }
    public void draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(color);
        graphicsContext.fillRect(x,y,size,size);
    }
}