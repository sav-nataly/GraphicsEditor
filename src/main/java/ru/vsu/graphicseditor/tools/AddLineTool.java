package ru.vsu.graphicseditor.tools;

import ru.vsu.graphicseditor.canvas.Layer;
import ru.vsu.graphicseditor.shape.Line;

import java.awt.*;
import java.util.List;

public class AddLineTool extends AddTool {
    public static Layer add(List<Point> pointList, Color color, Color borderColor, int width, int layerNum){
        return new Layer(new Line(pointList, color, borderColor, width), layerNum);
    }
    public static Layer add(Line line, int layerNum){
        return new Layer(line, layerNum);
    }
}
