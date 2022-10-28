package com.william_k.labb3;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
/*todo
*  läsa ner det till svg fil
*  2 tester
* */
public class PaintViewController {
    public Canvas canvas;
    public GraphicsContext context;
    public ColorPicker colorPicker;
    public TextField shapeSize;
    ShapesModel shapesModel = new ShapesModel();
    ShapeType shapeType;
    public void initialize(){
        context = canvas.getGraphicsContext2D();
        shapeSize.textProperty().bindBidirectional(shapesModel.sizeProperty());
        colorPicker.valueProperty().bindBidirectional(shapesModel.colorProperty());
    }
    public void circleButton() {
        shapesModel.setShapeType(ShapeType.CIRCLE);
    }

    public void rectangleButton() {
        shapesModel.setShapeType(ShapeType.SQUARE);
    }
    public void canvasClick(MouseEvent mouseEvent) {
        shapesModel.addCircle(mouseEvent);
        shapesModel.addSquare(mouseEvent);
        render();
    }
    public void render(){
        context.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        for (int i = 0; i < shapesModel.getShapes().size(); i++) {
            shapesModel.draw(context);
        }
    }
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.Z ) {
            shapesModel.removeLastShape();
            render();
        }
    }
}
