package com.william_k.labb3;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static com.william_k.labb3.ShapeType.CIRCLE;
import static com.william_k.labb3.ShapeType.SQUARE;

public class PaintViewController {
    public Canvas canvas;
    public GraphicsContext context;
    public ColorPicker colorPicker;
    public TextField shapeSize;
    ArrayList<ShapesModel> shapes = new ArrayList<>();
    ShapeType shapeType;
    public void initialize(){
        context = canvas.getGraphicsContext2D();
    }

    /*public PaintViewController(){
        this.shapeSize = new TextField();
    }*/

    public void circleButton(ActionEvent actionEvent) {
        shapeType = CIRCLE;
    }

    public void rectangleButton(ActionEvent actionEvent) {
        shapeType = SQUARE;
    }
    public void canvasClick(MouseEvent mouseEvent) {
        //make it add to array
        if(shapeType!=null)
            shapes.add(new ShapesModel((int)mouseEvent.getX(),(int)mouseEvent.getY(), colorPicker.getValue(), Integer.parseInt(shapeSize.getText()),shapeType));
        render();
    }
    public void render(){
        for (int i = 0; i < shapes.size(); i++) {
            context.setFill(shapes.get(i).getColor());
            if (shapes.get(i).getShape()==CIRCLE)
               context.fillOval(shapes.get(i).x,shapes.get(i).y,shapes.get(i).getSize(),shapes.get(i).getSize());
           if (shapes.get(i).getShape()==SQUARE)
               context.fillRect(shapes.get(i).x,shapes.get(i).y,shapes.get(i).getSize(),shapes.get(i).getSize());
        }
    }

}
