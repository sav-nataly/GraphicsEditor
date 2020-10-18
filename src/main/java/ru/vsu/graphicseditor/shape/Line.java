package ru.vsu.graphicseditor.shape;

import java.awt.*;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

public class Line extends Shape {
    public Line(List<Point> pointList, Color color, Color borderColor, int stroke) {
        super(pointList, color, borderColor, stroke);
    }

    public Line(List<Point> pointList) {
        super(pointList);
    }

    public Line(int x1, int y1, int x2, int y2, Color color, Color borderColor, int stroke){
        super(Arrays.asList(new Point(x1, y1), new Point(x2, y2)), color, borderColor, stroke);
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
