package com.william_k.labb3;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

public class ShapesModel {
    int x;
    int y;
    Color color;
    int size;
    ShapeType shape;

    public ShapesModel(int x, int y, Color color, int size, ShapeType shape) {
        //fixa default color, size
            this.x = x;
            this.y = y;
        if (color!=null)
            this.color = color;
        else
            this.color = Color.BLACK;
        this.size = size;
        this.shape = shape;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return size;
    }

    public ShapeType getShape() {
        return shape;
    }

    public void setShape(ShapeType shape) {
        this.shape = shape;
    }
}
