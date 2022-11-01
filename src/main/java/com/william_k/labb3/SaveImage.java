package com.william_k.labb3;

import javafx.scene.canvas.Canvas;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class SaveImage {

    public Stage stage;
    public Canvas canvas;
    public ArrayList<Shape> shapes;
    public SaveImage(ArrayList<Shape> shapes, Canvas canvas, Stage stage) {
        this.stage = stage;
        this.canvas = canvas;
        this.shapes = shapes;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void saveFile(){
        try {
            PrintStream fileStream = new PrintStream(fileChooser());
            writeSvgCode(fileStream);
            fileStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeSvgCode(PrintStream fileStream) {
        fileStream.println("<?xml version=\"1.0\"?>");
        fileStream.println("<svg width=\""+ canvas.getWidth()+"\" height=\""+ canvas.getHeight()+"\" xmlns=\"http://www.w3.org/2000/svg\">");
        saveShapes(fileStream);
        fileStream.println("</svg>");
    }

    private void saveShapes(PrintStream fileStream) {
        for (int i = 0; i < shapes.size(); i++) {
            if(shapes.get(i).getClass().equals(Circle.class)){
                fileStream.println("\t<circle r=\""+shapes.get(i).size/2+"\" cx=\""+shapes.get(i).x+"\" cy=\""+shapes.get(i).y+"\" fill=\"#"+formatColor(shapes,i)+"\"/>");
            }
            if(shapes.get(i).getClass().equals(Square.class))
                fileStream.println("\t<rect width=\""+ shapes.get(i).size+"\" height=\""+ shapes.get(i).size+"\" x=\""+ shapes.get(i).x+"\" y=\""+ shapes.get(i).y+"\" fill=\"#"+formatColor(shapes, i)+"\"/>");
        }
    }
    private File fileChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Spara som");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG","*.svg"));
        File file = fileChooser.showSaveDialog(stage);
        return file;
    }

    private StringBuilder formatColor(ArrayList<Shape> shapes, int i) {
        StringBuilder color = new StringBuilder(shapes.get(i).color.toString());
        color.deleteCharAt(9);
        color.deleteCharAt(8);
        color.deleteCharAt(1);
        color.deleteCharAt(0);
        return color;
    }
}
