package com.william_k.labb3;

import javafx.scene.canvas.Canvas;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
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
        for (Shape shape : shapes) {
            fileStream.println(shape.convertToSvg());
        }
    }
    private File fileChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Spara som");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG","*.svg"));
        return fileChooser.showSaveDialog(stage);
    }
}
