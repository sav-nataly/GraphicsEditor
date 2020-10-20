package ru.vsu.graphicseditor.tools;

import ru.vsu.graphicseditor.canvas.Layer;
import ru.vsu.graphicseditor.shape.Shape;

import java.awt.*;

public class BucketTool {
    public static void color(int x, int y, Layer layer, Color selectedColor) {
        Shape shape = SelectTool.selectShape(x, y, layer.getShapes());
        if (shape != null) {
            shape.setColor(selectedColor);
        } else {
            layer.setBackgroundColor(selectedColor);
        }
    }
}
