package com.william_k.labb3;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

import static com.william_k.labb3.ShapeType.CIRCLE;
import static com.william_k.labb3.ShapeType.SQUARE;
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
    }
    public void circleButton() {
        shapesModel.setShapeType(CIRCLE);
    }

    public void rectangleButton() {
        shapesModel.setShapeType(SQUARE);
    }
    public void canvasClick(MouseEvent mouseEvent) {

        if (shapesModel.getShapeType()==CIRCLE) {
            Shape temp = new Circle((int) mouseEvent.getX(), (int) mouseEvent.getY(), colorPicker.getValue(), Integer.parseInt(shapeSize.getText()));
            shapesModel.addShape(temp);
        }
        if (shapesModel.getShapeType()==SQUARE) {
            Shape temp = new Square((int) mouseEvent.getX(), (int) mouseEvent.getY(), colorPicker.getValue(), Integer.parseInt(shapeSize.getText()));
            shapesModel.addShape(temp);
        }
        render();
    }
    public void render(){
        context.clearRect(0,0,canvas.getWidth(),canvas.getHeight());

        for (int i = 0; i < shapesModel.getShapes().size(); i++) {
            context.setFill(shapesModel.getShapes().get(i).getColor());
            if(shapesModel.getShapes().get(i) instanceof Circle){
                context.fillOval(shapesModel.getShapes().get(i).x, shapesModel.getShapes().get(i).y, shapesModel.getShapes().get(i).getSize(), shapesModel.getShapes().get(i).getSize());
            }
            if (shapesModel.getShapes().get(i) instanceof Square){
                context.fillRect(shapesModel.getShapes().get(i).x, shapesModel.getShapes().get(i).y, shapesModel.getShapes().get(i).getSize(), shapesModel.getShapes().get(i).getSize());
            }
        }
    }
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.Z ) {
            shapesModel.removeLastShape();
            render();
        }
    }
}
