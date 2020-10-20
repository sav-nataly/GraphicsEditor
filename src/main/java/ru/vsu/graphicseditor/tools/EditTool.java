package ru.vsu.graphicseditor.tools;

import ru.vsu.graphicseditor.math.Calculations;
import ru.vsu.graphicseditor.shape.Shape;

import java.awt.*;

public class EditTool {
    public static void moveShape(int x1, int y1, int x2, int y2, Shape shape) {
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;

        shape.getPointList().forEach(p -> p.setLocation(p.getX() + deltaX, p.getY() + deltaY));
        shape.updateBounds();
    }

    public static void scaleShape(int x1, int y1, int x2, int y2, Shape shape) {
        int movingPointIndex = shape.getBounds().indexOf(new Point(x1, y1));

        if (movingPointIndex > -1) {
            int deltaX = x2 - x1;
            int deltaY = y2 - y1;
            int width = shape.getBounds().get(3).x - shape.getBounds().get(0).x;
            int height = shape.getBounds().get(1).y - shape.getBounds().get(0).y;

            Point scalingPoint = shape.getBounds().get(movingPointIndex >= 2 ? movingPointIndex - 2 : movingPointIndex + 2);

            moveShape(scalingPoint.x, scalingPoint.y, 0, 0, shape);

            shape.getPointList().forEach(p -> p.setLocation(p.getX() * (1 - (double) deltaX / width),
                    p.getY() * (1 - (double) deltaY / height)));

            moveShape(0, 0, scalingPoint.x, scalingPoint.y, shape);
        }
    }

    public static void rotateShape(int x1, int y1, int x2, int y2, Shape shape) {
        int centerX = (shape.getBounds().get(0).x + shape.getBounds().get(2).x) / 2;
        int centerY = (shape.getBounds().get(0).y + shape.getBounds().get(2).y) / 2;

        double cos = Calculations.findAngle(x1, y1, x2, y2, centerX, centerY);
        double sin = Math.sin(Math.acos(cos)) * Math.signum(y2 - y1);

        moveShape(centerX, centerY, 0, 0, shape);

        shape.getPointList().forEach(p -> p.setLocation((int) (p.getX() * cos + p.getY() * sin),
                (int) (-p.getX() * sin + p.getY() * cos)));

        moveShape(0, 0, centerX, centerY, shape);
    }
}
