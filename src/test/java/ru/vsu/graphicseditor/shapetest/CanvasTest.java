package ru.vsu.graphicseditor.shapetest;

import org.junit.Test;
import ru.vsu.graphicseditor.canvas.Canvas;
import ru.vsu.graphicseditor.shape.Line;
import ru.vsu.graphicseditor.shape.Polygon;
import ru.vsu.graphicseditor.tools.*;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CanvasTest {
    @Test
    public void canvasTest(){
        Canvas canvas = new Canvas(700, 700, Color.WHITE);

        assertEquals(1, canvas.getLayerList().size());

        canvas.addNewLayer();
        assertEquals("Layer1", canvas.getLayerList().get(1).getName());

        canvas.moveLayer(1, 0);
        assertEquals("Layer1", canvas.getLayerList().get(0).getName());

        canvas.addNewLayer();
        canvas.addNewLayer();
        canvas.addNewLayer();
        canvas.moveLayer(4, 1);

        canvas.setCurrentLayer(2);
        Line line = new Line(120, 120, 30, 30, Color.BLACK, Color.BLACK, 2);
        canvas.addShapeLayer(AddLineTool.add(line, canvas.getCurrentLayerNumber() + 1));
        canvas.renameLayer(3, "Line1");
        assertEquals("Line pointList=[java.awt.Point[x=120,y=120], " +
                "java.awt.Point[x=30,y=30]]borderColor=java.awt.Color[r=0,g=0,b=0]color=java.awt.Color[r=0,g=0,b=0]stroke=2",
                canvas.getLayerList().get(3).getShapes().get(0).toString());
        assertEquals("Line1", canvas.getLayerList().get(3).getName());

        canvas.addShapeLayer(AddPolygonTool.add(new Polygon(Arrays.asList(new Point(150, 0),
                new Point(150, 80), new Point(150, 40)), Color.red, Color.red, 2),
                canvas.getCurrentLayerNumber() + 1));
        canvas.combineLayers(3, 4);
        assertEquals(Color.red, canvas.getCurrentLayer().getShapes().get(1).getColor());

        BucketTool.color(50, 50, canvas.getCurrentLayer(), Color.CYAN);
        assertEquals(Color.CYAN, canvas.getLayerList().get(3).getShapes().get(0).getColor());

        BucketTool.color(0, 0, canvas.getCurrentLayer(), Color.GREEN);
        assertEquals(Color.CYAN, canvas.getLayerList().get(3).getShapes().get(0).getColor());
        assertEquals(Color.red, canvas.getCurrentLayer().getShapes().get(1).getColor());
        assertEquals(Color.GREEN, canvas.getLayerList().get(3).getBackgroundColor());

        DeleteTool.deleteShape(50, 50, canvas.getCurrentLayer().getShapes());
        assertEquals(1, canvas.getCurrentLayer().getShapes().size());

        canvas.deleteLayer(0);
        assertEquals(5, canvas.getLayerList().size());

        canvas.deleteLayer(0);
        canvas.deleteLayer(0);
        canvas.deleteLayer(0);
        canvas.deleteLayer(0);
        canvas.deleteLayer(0);
        assertEquals(1, canvas.getLayerList().size());
    }
}
