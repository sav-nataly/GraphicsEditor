package ru.vsu.graphicseditor.shape;

import java.awt.*;
import java.awt.Point;
import java.util.List;

public abstract class Shape {
    private List<Point> pointList;
    private Color color;
    private Color borderColor;
    private int stroke;



    private double minX;
    private double minY;
    private double maxX;
    private double maxY;

    public Shape(List<Point> pointList, Color color, Color borderColor, int stroke) {
        this.pointList = pointList;
        this.color = color;
        this.borderColor = borderColor;
        this.stroke = stroke;
        setBounds();
    }

    public Shape(List<Point> pointList) {
        this.pointList = pointList;
        setBounds();
    }

    public Shape(){}

    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
        setBounds();
    }

    public Point getPoint(int index){
        return pointList.get(index);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    void setBounds(){
        double minX = Integer.MAX_VALUE;
        double maxX = -1;
        double minY = Integer.MAX_VALUE;
        double maxY = -1;
        for (Point p : pointList) {
            minX = Math.min(p.getX(), minX);
            maxX = Math.max(p.getX(), maxX);
            minY = Math.min(p.getY(), minY);
            maxY = Math.max(p.getY(), maxY);
        }

        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean inBounds(int x, int y){
        return x >= minX & x <= maxX & y >= minY && y <= maxY;
    }

    public double[] getBounds(){
        return new double[]{minX, minY, maxX, maxY};
    }

    @Override
    public String toString() {
        return "Shape" +
                "pointList=" + pointList.toString() +
                ", color=" + color +
                ", borderColor=" + borderColor +
                ", stroke=" + stroke;
    }
}
