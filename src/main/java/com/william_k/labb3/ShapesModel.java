package com.william_k.labb3;
import javafx.beans.property.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ShapesModel {
    private StringProperty sizeText;
    private ObjectProperty color;

    ArrayList<Shape> shapes = new ArrayList<>();
    ShapeType shapeType;
    public StringProperty sizeProperty() {
        return sizeText;
    }
    public ObjectProperty colorProperty(){
        return color;
    }
    public ShapesModel(){
        sizeText = new SimpleStringProperty();
        color = new SimpleObjectProperty(Color.BLACK);
    }
    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
    public void addShape(Shape shape){
        if(shapeType!=null)
            shapes.add(shape);
    }
    public ArrayList<Shape> getShapes() {
        return shapes;
    }
    public void addCircle(MouseEvent mouseEvent) {
        if (shapeType==ShapeType.CIRCLE) {
            Shape temp = new Circle((int) mouseEvent.getX(), (int) mouseEvent.getY(), (Color) color.get(), Integer.parseInt(sizeText.getValue()));
            addShape(temp);
        }
    }
    public void addSquare(MouseEvent mouseEvent) {
        if (shapeType==ShapeType.SQUARE) {
            Shape temp = new Square((int) mouseEvent.getX(), (int) mouseEvent.getY(), (Color) color.get(), Integer.parseInt(sizeText.getValue()));
            addShape(temp);
        }
    }
    public void removeLastShape() {
        if (shapes.size()!=0)
            shapes.remove(shapes.size() - 1);
    }


    public ShapeType getShapeType() {
        return shapeType;
    }

    public void draw(GraphicsContext context) {
        shapes.forEach(i->i.draw(context));
    }
}
