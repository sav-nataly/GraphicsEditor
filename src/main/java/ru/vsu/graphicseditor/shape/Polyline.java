package ru.vsu.graphicseditor.shape;

import java.awt.*;
import java.awt.Point;
import java.util.List;

public class Polyline extends Shape {
    private int nPoints;

    public Polyline(List<Point> pointList, Color color, Color borderColor, int stroke) {
        super(pointList, color, borderColor, stroke);
        this.nPoints = pointList.size();
    }

    public Polyline(List<Point> pointList) {
        super(pointList);
        this.nPoints = pointList.size();
    }

    public Polyline() {
    }

    public int getNPoints() {
        return nPoints;
    }

    public void addPoint(Point point){
        getPointList().add(point);
        nPoints++;
        setBounds();
    }

    public void addPoint(int x, int y){
        getPointList().add(new Point(x, y));
        nPoints++;
        setBounds();
    }

    public void deletePoint(int x, int y){
        getPointList().remove(new Point(x, y));
        nPoints--;
        setBounds();
    }

    @Override
    public String toString() {
        return "Polyline " +
                "nPoints=" + nPoints +
                " pointList=" + getPointList().toString()
                + " borderColor=" + getBorderColor()
                + " color=" + getColor()
                + " stroke=" + getStroke();
    }
}
