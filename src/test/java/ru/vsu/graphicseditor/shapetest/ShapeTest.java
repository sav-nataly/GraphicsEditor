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
        assertEquals("java.awt.Point[x=3,y=4]", polyline.getPoint(1).toString());
    }
}
