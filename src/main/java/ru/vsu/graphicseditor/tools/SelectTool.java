package ru.vsu.graphicseditor.tools;

import ru.vsu.graphicseditor.shape.Shape;

import java.util.List;

public class SelectTool {
    public static Shape selectShape(int x, int y, List<Shape> shapes){
        for (Shape shape : shapes) {
            if (shape.inBounds(x, y)) return shape;
        }
        return null;
    }
}
