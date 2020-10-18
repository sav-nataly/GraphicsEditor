package ru.vsu.graphicseditor.tools;

import ru.vsu.graphicseditor.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class SelectTool {
    public static Shape selectShape(int x, int y, List<Shape> shapes){
        for (Shape shape : shapes) {
            if (shape.inBounds(x, y)) return shape;
        }
        return null;
    }
    public static List<Shape> selectShape(int x1, int y1, int x2, int y2, List<Shape> shapes){
        if (x1 > x2) {
            int curr = x1;
            x1 = x2;
            x2 = curr;
        }

        if (y1 > y2) {
            int curr = y1;
            y1 = y2;
            y2 = curr;
        }

        List<Shape> selected = new ArrayList<>();

        for (Shape shape : shapes){
            double[] bounds = shape.getBounds();

            if (bounds[0] > x1 && bounds[0] < x2 && bounds[1] > y1 && bounds[1] < y2
            || bounds[2] > x1 && bounds[2] < x2 && bounds[3] > y1 && bounds[3] < y2) selected.add(shape);
        }

        return selected;
    }
}
