package ru.vsu.graphicseditor.canvas;

import ru.vsu.graphicseditor.shape.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Layer {
    List<Shape> shapes = new ArrayList<>();
    String name;
    Color backgroundColor;

    public Layer(List<Shape> shapes, int layerNum) {
        this.shapes = shapes;
        name = "Layer" + layerNum;
    }
    public Layer(Shape shape, int layerNum) {
        shapes.add(shape);
        name = "Layer" + layerNum;
    }

    public Layer(int layerNum) {
        name = "Layer" + layerNum;
    }

    public Layer(Color backgroundColor, int layerNum) {
        this.backgroundColor = backgroundColor;
        name = "Layer" + layerNum;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public void addShapes(List<Shape> shapes){
        shapes.addAll(shapes);
    }

    public void deleteShape(Shape shape){
        shapes.remove(shape);
    }
}
