package com.william_k.labb3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    int x;
    int y;
    Color color;
    int size;

    public void setColor(Color color) {
        this.color = color;
    }
    public void setSize(int size){
        this.size = size;
    }
    public void draw(GraphicsContext context){

    }
    public boolean pointInside(int xClick, int yClick){
        return false;
    }
    public void updatePos(){
    }

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                ", size=" + size +
                '}';
    }
}