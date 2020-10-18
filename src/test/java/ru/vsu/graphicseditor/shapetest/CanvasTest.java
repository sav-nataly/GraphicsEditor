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

        assertEquals(canvas.getLayerList().size(), 1);

        canvas.addNewLayer();
        assertEquals(canvas.getLayerList().get(1).getName(), "Layer1");

        canvas.moveLayer(1, 0);
        assertEquals(canvas.getLayerList().get(0).getName(), "Layer1");

        canvas.addNewLayer();
        canvas.addNewLayer();
        canvas.addNewLayer();
        canvas.moveLayer(4, 1);

        canvas.setCurrentLayer(2);
        Line line = new Line(120, 120, 30, 30, Color.BLACK, Color.BLACK, 2);
        canvas.addShapeLayer(AddLineTool.add(line, canvas.getCurrentLayerNumber() + 1));
        canvas.renameLayer(3, "Line1");
        assertEquals(canvas.getLayerList().get(3).getShapes().get(0).toString(), "Line pointList=[java.awt.Point[x=120,y=120], " +
                "java.awt.Point[x=30,y=30]]borderColor=java.awt.Color[r=0,g=0,b=0]color=java.awt.Color[r=0,g=0,b=0]stroke=2");
        assertEquals(canvas.getLayerList().get(3).getName(), "Line1");

        canvas.addShapeLayer(AddPolygonTool.add(new Polygon(Arrays.asList(new Point(150, 0),
                new Point(150, 80), new Point(150, 40)), Color.red, Color.red, 2),
                canvas.getCurrentLayerNumber() + 1));
        canvas.combineLayers(3, 4);
        assertEquals(canvas.getCurrentLayer().getShapes().get(1).getColor(), Color.red);

        BucketTool.color(50, 50, canvas.getCurrentLayer(), Color.CYAN);
        assertEquals(canvas.getLayerList().get(3).getShapes().get(0).getColor(), Color.CYAN);

        BucketTool.color(0, 0, canvas.getCurrentLayer(), Color.GREEN);
        assertEquals(canvas.getLayerList().get(3).getShapes().get(0).getColor(), Color.CYAN);
        assertEquals(canvas.getCurrentLayer().getShapes().get(1).getColor(), Color.red);
        assertEquals(canvas.getLayerList().get(3).getBackgroundColor(), Color.GREEN);

        DeleteTool.deleteShape(50, 50, canvas.getCurrentLayer().getShapes());
        assertEquals(canvas.getCurrentLayer().getShapes().size(), 1);

        canvas.deleteLayer(0);
        assertEquals(canvas.getLayerList().size(), 5);

        canvas.deleteLayer(0);
        canvas.deleteLayer(0);
        canvas.deleteLayer(0);
        canvas.deleteLayer(0);
        canvas.deleteLayer(0);
        assertEquals(canvas.getLayerList().size(), 1);
    }
}
