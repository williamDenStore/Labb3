package com.william_k.labb3;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

public class ShapesModel {
    int x;
    int y;
    private final ObjectProperty<Color> color;

    StringProperty size;
    public String getSize() {
        return size.get();
    }

    public void size(String size) {
        this.size.set(size);
    }
    public StringProperty sizeProperty() {
        return size;
    }
    public ObjectProperty<Color> colorProperty() {
        return color;
    }
    public ShapesModel() {
        this.color = new SimpleObjectProperty<>(Color.BLACK);
        size = new SimpleStringProperty();
    }


    public ShapeType getType() {
        return type;
    }

    public void Type(ShapeType type) {
        this.type = type;
    }

    ShapeType type;

    public int getX() {
        return x;
    }

    public void X(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void Y(int y) {
        this.y = y;
    }
}
