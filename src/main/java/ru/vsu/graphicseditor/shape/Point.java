package ru.vsu.graphicseditor.shape;

import java.awt.*;
import java.util.List;

public class Point extends Shape {
    public Point(){
    }
    public Point(List<java.awt.Point> pointList) {
        super(pointList);
    }

    public Point(List<java.awt.Point> pointList, Color color, Color borderColor, int stroke) {
        super(pointList, color, borderColor, stroke);
    }

    @Override
    public String toString() {
        return "Point "
                + "pointList=" + getPointList().toString()
                + "borderColor=" + getBorderColor()
                + "color=" + getColor()
                + "stroke=" + getStroke();
    }
}
