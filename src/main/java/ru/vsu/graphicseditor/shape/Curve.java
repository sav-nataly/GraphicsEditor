package ru.vsu.graphicseditor.shape;

import java.awt.*;
import java.util.List;

public class Curve extends Shape {
    private int nPoints;
    private int curvature;

    public Curve(List<PrimitivePoint> pointList, Color color, Color borderColor, int stroke) {
        super(pointList, color, borderColor, stroke);
        nPoints = pointList.size();
    }

    public Curve(List<PrimitivePoint> pointList) {
        super(pointList);
        nPoints = pointList.size();
    }

    public Curve() {
    }

    public Curve(List<PrimitivePoint> pointList, Color color, Color borderColor, int stroke, int curvature) {
        super(pointList, color, borderColor, stroke);
        this.curvature = curvature;
        nPoints = pointList.size();
    }

    public Curve(List<PrimitivePoint> pointList, int curvature) {
        super(pointList);
        this.curvature = curvature;
        nPoints = pointList.size();
    }

    public void setCurvature(int curvature) {
        this.curvature = curvature;
    }

    public int getNPoints() {
        return nPoints;
    }

    public int getCurvature() {
        return curvature;
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
        return "Curve " +
                "nPoints=" + nPoints +
                "curvature=" + curvature +
                "pointList=" + getPointList().toString()
                + "borderColor=" + getBorderColor()
                + "color=" + getColor()
                + "stroke=" + getStroke();
    }
}
