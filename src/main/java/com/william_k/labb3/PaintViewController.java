package com.william_k.labb3;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static com.william_k.labb3.ShapeType.CIRCLE;
import static com.william_k.labb3.ShapeType.SQUARE;

public class PaintViewController {
    public Canvas canvas;
    public GraphicsContext context;
    public ColorPicker colorPicker;
    public TextField shapeSize;
    ShapesModel shapes = new ShapesModel();
    ShapeType shapeType;
    public void initialize(){
        context = canvas.getGraphicsContext2D();
        colorPicker.valueProperty().bindBidirectional(shapes.colorProperty());
        shapeSize.textProperty().bindBidirectional(shapes.sizeProperty());
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
        int size = Integer.parseInt(shapeSize.getText());
        context.setFill(colorPicker.getValue());
        if (shapeType == CIRCLE) {
            context.fillOval(mouseEvent.getX(), mouseEvent.getY(), size, size);
        }
        if (shapeType == SQUARE) {
            context.fillRect(mouseEvent.getX(), mouseEvent.getY(), size, size);
        }
    }
}
