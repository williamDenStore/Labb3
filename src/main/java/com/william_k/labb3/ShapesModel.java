package com.william_k.labb3;
import javafx.beans.property.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ShapesModel {
    private StringProperty sizeText;
    private ObjectProperty color;



    private Boolean edit = false;
    private ArrayList<Shape> shapes = new ArrayList<>();
    ShapeType shapeType;
    public void setEdit(Boolean edit) {
        this.edit = edit;
    }
    public Boolean getEdit() {
        return edit;
    }
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
    public void addShape(MouseEvent mouseEvent) {
        if (shapeType==ShapeType.CIRCLE) {
            Shape temp = new Circle((int) mouseEvent.getX(), (int) mouseEvent.getY(), (Color) color.get(), Integer.parseInt(sizeText.getValue()));
            addShape(temp);
        }
        if (shapeType==ShapeType.SQUARE) {
            Shape temp = new Square((int) mouseEvent.getX(), (int) mouseEvent.getY(), (Color) color.get(), Integer.parseInt(sizeText.getValue()));
            addShape(temp);
        }
    }

    public void removeLastShape() {
        if (shapes.size()!=0)
            shapes.remove(shapes.size() - 1);
    }

    public int getIndexOfShapeInCoordinate(int x, int y){
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).pointInside(x,y)){
                return i;
            }
        }
        return -1;
    }

    public void draw(GraphicsContext context) {
        shapes.forEach(shape->shape.draw(context));
    }
    public void canvasClick(MouseEvent mouseEvent){
        if (!edit)
            addShape(mouseEvent);
        if (edit){
            int i = getIndexOfShapeInCoordinate((int) mouseEvent.getX(), (int) mouseEvent.getY());
            if (i!=-1) {
                shapes.get(i).setColor((Color) color.get());
                shapes.get(i).setSize(Integer.parseInt(sizeText.getValue()));
                shapes.get(i).updatePos();
            }
        }

    }

    public void save(Canvas canvas, Stage stage) {
        SaveImage saveImage = new SaveImage(shapes,canvas,stage);
        saveImage.saveFile();
    }
}
