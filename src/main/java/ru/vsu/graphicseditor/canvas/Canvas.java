package ru.vsu.graphicseditor.canvas;

import java.awt.*;
import java.util.List;
import ru.vsu.graphicseditor.shape.Shape;

public class Canvas {
    private int width;
    private int height;
    private Color backgroundColor;

    private List<Shape> shapeList;

    public Canvas(int width, int height, Color backgroundColor) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
    }

    public Canvas(int width, int height, Color backgroundColor, List<Shape> shapeList) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.shapeList = shapeList;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Canvas(){}

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public void setShapeList(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public void addShape(Shape shape) {
        shapeList.add(shape);
    }

    public void addShapes(List<Shape> shapes){
        shapeList.addAll(shapes);
    }

    public Shape getShape(int x, int y){
        for (Shape s : shapeList) {
            if (s.inBounds(x, y))
                return s;
        }
        return null;
    }

    public void deleteShape(int x, int y) {
        Shape s = getShape(x, y);
        if (s != null) shapeList.remove(s);
    }
}
