package com.william_k.labb3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
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
    public String convertToSvg(){
        return "";
    }
    public StringBuilder formatColor() {
            StringBuilder colorstr = new StringBuilder(color.toString());
            colorstr.deleteCharAt(9);
            colorstr.deleteCharAt(8);
            colorstr.deleteCharAt(1);
            colorstr.deleteCharAt(0);
            return colorstr;
    }
    public static Shape createShape(ShapeType shapeType, MouseEvent mouseEvent, Color color, int size){
        return switch (shapeType){
            case CIRCLE -> new Circle((int) mouseEvent.getX(), (int) mouseEvent.getY(), color, size);
            case SQUARE -> new Square((int) mouseEvent.getX(), (int) mouseEvent.getY(), color, size);
        };
    }
}