package ru.vsu.graphicseditor.tools;

import ru.vsu.graphicseditor.shape.Shape;

import java.util.List;

public class DeleteTool {
    public static void deleteShape(int x, int y, List<Shape> shapeList){
        Shape selected = SelectTool.selectShape(x, y, shapeList);
        if (selected != null) {
            shapeList.remove(selected);
        }
    }

    public static void deleteShape(int x1, int y1, int x2, int y2, List<Shape> shapeList){
        if (shapeList.size() > 0){
            shapeList.removeAll(shapeList);
        }
    }
}
