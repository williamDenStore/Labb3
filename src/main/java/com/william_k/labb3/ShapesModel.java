package com.william_k.labb3;
import javafx.beans.property.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ShapesModel {
    private final StringProperty sizeText;
    private final ObjectProperty color;
    static Deque<Runnable> undoStack = new ArrayDeque<>();
    private Boolean edit = false;
    private final ArrayList<Shape> shapes = new ArrayList<>();
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
    public ArrayList<Shape> getShapes() {
        return shapes;
    }
    public void addShape(MouseEvent mouseEvent) {
        undoStack.push(()-> shapes.remove(shapes.size()-1));
        shapes.add(Shape.createShape(shapeType, mouseEvent, (Color) color.get(), Integer.parseInt(sizeText.getValue())));
    }
    public void removeLastCommand(){
        Runnable undoToExecute = undoStack.pop();
        undoToExecute.run();
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
            if (i>=0) {
                Color oldColor = shapes.get(i).color;
                undoStack.push(()-> shapes.get(i).setColor(oldColor));
                shapes.get(i).setColor((Color) color.get());

                int oldSize = shapes.get(i).size;
                undoStack.push(()-> shapes.get(i).setSize(oldSize));
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
