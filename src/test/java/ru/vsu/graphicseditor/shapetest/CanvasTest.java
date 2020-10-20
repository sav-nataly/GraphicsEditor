package ru.vsu.graphicseditor.shapetest;

import org.junit.Test;
import ru.vsu.graphicseditor.canvas.Canvas;
import ru.vsu.graphicseditor.shape.Line;
import ru.vsu.graphicseditor.shape.Polygon;
import ru.vsu.graphicseditor.shape.Shape;
import ru.vsu.graphicseditor.tools.*;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CanvasTest {
    Canvas canvas = new Canvas(700, 700, Color.WHITE);

    @Test
    public void layerTest() {

        assertEquals(1, canvas.getLayerList().size());

        canvas.addNewLayer();
        assertEquals("Layer1", canvas.getLayerList().get(1).getName());

        canvas.moveLayer(1, 0);
        assertEquals("Layer1", canvas.getLayerList().get(0).getName());

        canvas.addNewLayer();
        canvas.addNewLayer();
        canvas.addNewLayer();
        canvas.moveLayer(4, 1);

        canvas.renameLayer(3, "Line1");
        assertEquals("Line1", canvas.getLayerList().get(3).getName());
    }

    @Test
    public void addAndDeleteTest() {
        canvas.addNewLayer();
        canvas.addNewLayer();
        canvas.addNewLayer();

        canvas.setCurrentLayer(2);
        Line line = new Line(120, 120, 30, 30, Color.BLACK, Color.BLACK, 2);
        canvas.addShapeLayer(AddTool.add(line, canvas.getCurrentLayerNumber() + 1));
        assertEquals(1, canvas.getCurrentLayer().getShapes().size());

        DeleteTool.deleteShape(70, 70, canvas.getCurrentLayer().getShapes());
        assertEquals(0, canvas.getCurrentLayer().getShapes().size());

        canvas.addShapeLayer(AddTool.add(line, canvas.getCurrentLayerNumber() + 1));

        canvas.addShapeLayer(AddTool.add(new Polygon(Arrays.asList(new Point(150, 0),
                new Point(150, 80), new Point(150, 40)), Color.red, Color.red, 2),
                canvas.getCurrentLayerNumber() + 1));
        canvas.combineLayers(4, 5);
        assertEquals(Color.red, canvas.getCurrentLayer().getShapes().get(1).getColor());
    }

    @Test
    public void bucketTest() {
        Line line = new Line(120, 120, 30, 30, Color.BLACK, Color.BLACK, 2);
        canvas.addShapeLayer(AddTool.add(line, canvas.getCurrentLayerNumber() + 1));
        canvas.addShapeLayer(AddTool.add(new Polygon(Arrays.asList(new Point(150, 0),
                new Point(150, 80), new Point(150, 40)), Color.red, Color.red, 2),
                canvas.getCurrentLayerNumber() + 1));
        canvas.combineLayers(1, 2);

        BucketTool.color(50, 50, canvas.getCurrentLayer(), Color.CYAN);
        assertEquals(Color.CYAN, canvas.getLayerList().get(1).getShapes().get(0).getColor());

        BucketTool.color(0, 0, canvas.getCurrentLayer(), Color.GREEN);

        assertEquals(Color.CYAN, canvas.getLayerList().get(1).getShapes().get(0).getColor());
        assertEquals(Color.red, canvas.getCurrentLayer().getShapes().get(1).getColor());
        assertEquals(Color.GREEN, canvas.getLayerList().get(1).getBackgroundColor());
    }

    @Test
    public void transformationTest() {
        Line line = new Line(120, 120, 30, 30, Color.BLACK, Color.BLACK, 2);
        canvas.addShapeLayer(AddTool.add(line, canvas.getCurrentLayerNumber() + 1));

        Shape shape = SelectTool.selectShape(50, 50, canvas.getCurrentLayer().getShapes());

        EditTool.scaleShape(30, 30, 0, 0, shape);
        assertEquals(0, canvas.getCurrentLayer().getShapes().get(0).getBounds().get(1).x);

        EditTool.scaleShape(0, 0, 30, 30, shape);

        EditTool.moveShape(50, 50, 70, 70, shape);
        assertEquals(50, canvas.getCurrentLayer().getShapes().get(0).getPoint(1).x);

        EditTool.rotateShape(0, 0, 10, -10, shape);
        assertTrue(shape.getPoint(0).x < 140 && shape.getPoint(0).x >= 50);
    }

    @Test
    public void deleteTest() {
        canvas.addNewLayer();
        canvas.addNewLayer();
        canvas.addNewLayer();
        canvas.addNewLayer();
        canvas.addNewLayer();

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
