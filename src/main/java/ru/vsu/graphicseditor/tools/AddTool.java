package ru.vsu.graphicseditor.tools;

import ru.vsu.graphicseditor.canvas.Layer;
import ru.vsu.graphicseditor.shape.Shape;

public class AddTool {
    public static Layer add(Shape shape, int layerNum){
        return new Layer(shape, layerNum);
    }
}
