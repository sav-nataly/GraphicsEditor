package ru.vsu.graphicseditor.tools;

import ru.vsu.graphicseditor.canvas.Layer;
import ru.vsu.graphicseditor.shape.Polygon;

import java.awt.*;
import java.util.List;
import java.util.Arrays;

public class AddPolygonTool extends AddTool {
    public static Layer add(List<Point> pointList, Color color, Color borderColor, int stroke, int layerNum){
        return new Layer(new Polygon(pointList, color, borderColor, stroke), layerNum);
    }
    public static Layer add(Polygon polygon, int layerNum){
        return new Layer(polygon, layerNum);
    }
}
