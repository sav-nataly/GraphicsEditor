package ru.vsu.graphicseditor.shape;

import java.awt.*;
import java.util.List;

public class Line extends Shape {
    public Line(List<PrimitivePoint> pointList, Color color, Color borderColor, int stroke) {
        super(pointList, color, borderColor, stroke);
    }

    public Line(List<PrimitivePoint> pointList) {
        super(pointList);
    }

    public Line() {
    }

    @Override
    public String toString() {
        return "Line "
                + "pointList=" + getPointList().toString()
                + "borderColor=" + getBorderColor()
                + "color=" + getColor()
                + "stroke=" + getStroke();
    }
}
