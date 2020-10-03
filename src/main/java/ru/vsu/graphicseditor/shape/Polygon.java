package ru.vsu.graphicseditor.shape;

import java.awt.*;
import java.util.List;

public class Polygon extends Shape {
    private int nPoints;

    public Polygon(List<PrimitivePoint> pointList, Color color, Color borderColor, int stroke) {
        super(pointList, color, borderColor, stroke);
        nPoints = pointList.size();
    }

    public Polygon(List<PrimitivePoint> pointList) {
        super(pointList);
        nPoints = pointList.size();
    }

    public Polygon() {
    }

    public int getNPoints() {
        return nPoints;
    }

    public void addPoint(PrimitivePoint point){
        getPointList().add(point);
        nPoints++;
        setBounds();
    }

    public void addPoint(int x, int y){
        getPointList().add(new PrimitivePoint(x, y));
        nPoints++;
        setBounds();
    }

    public void deletePoint(int x, int y){
        getPointList().remove(new PrimitivePoint(x, y));
        nPoints--;
        setBounds();
    }

    @Override
    public String toString() {
        return "Polygon " +
                "nPoints=" + nPoints +
                "pointList=" + getPointList().toString()
                + "borderColor=" + getBorderColor()
                + "color=" + getColor()
                + "stroke=" + getStroke();
    }
}
