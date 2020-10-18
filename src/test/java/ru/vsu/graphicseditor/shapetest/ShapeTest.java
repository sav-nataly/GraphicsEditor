package ru.vsu.graphicseditor.shapetest;

import org.junit.Test;
import ru.vsu.graphicseditor.canvas.Canvas;
import ru.vsu.graphicseditor.shape.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ShapeTest {
    @Test
    public void shapeTest(){
        ArrayList<java.awt.Point> pointArrayList = new ArrayList<>();
        pointArrayList.add(new Point(3, 4));
        pointArrayList.add(new Point(5, 6));
        pointArrayList.add(new Point(3, 4));

        Polyline polyline = new Polyline(pointArrayList);

        polyline.deletePoint(3, 4);

        assertEquals(2, polyline.getPointList().size());
        assertEquals(2, polyline.getNPoints());
        assertEquals("PrimitivePoint x=3, y=4", polyline.getPoint(1).toString());
    }

//    @Test
//    public void canvasTest(){
//        Canvas canvas = new Canvas();
//        ArrayList<Point> pointArrayList = new ArrayList<>();
//        pointArrayList.add(new Point(3, 4));
//        pointArrayList.add(new Point(5, 6));
//        pointArrayList.add(new Point(7, 4));
//
//        ArrayList<java.awt.Point> pointArrayList2 = new ArrayList<>();
//        pointArrayList2.add(new Point(0, 0));
//        pointArrayList2.add(new Point(2, 3));
//        pointArrayList2.add(new Point(3, 0));
//
//        List<Shape> shapes = new ArrayList<>();
//        shapes.add(new Polyline(pointArrayList));
//        shapes.add(new Polygon(pointArrayList2));
//        shapes.add(new Line());
//
//        canvas.setShapeList(shapes);
//
//        canvas.getShapeList().remove(2);
//        assertEquals(2, canvas.getShapeList().size());
//
//        Shape shape = canvas.getShape(5, 5);
//        assertEquals("Polyline nPoints=3 pointList=[java.awt.Point[x=3,y=4], " +
//                "java.awt.Point[x=5,y=6], java.awt.Point[x=7,y=4]] borderColor=null color=null stroke=0", shape.toString());
//
//        canvas.deleteShape(2, 2);
//        assertEquals(1, canvas.getShapeList().size());
//
//        canvas.addShape(new Line());
//        assertEquals(2, canvas.getShapeList().size());

//    }
}
