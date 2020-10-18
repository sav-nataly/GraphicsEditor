package ru.vsu.graphicseditor.math;

public class Calculations {
    public static double findAngle(int x1, int y1, int x2, int y2, int cX, int cY){
        int deltaX1 = x1 - cX;
        int deltaX2 = x2 - cX;
        int deltaY1 = y1 - cY;
        int deltaY2 = y2 - cY;

        double cos = (deltaX1 * deltaX2 + deltaY1 * deltaY2) / Math.sqrt(deltaX1 * deltaX1 + deltaY1 *deltaY1)
                / Math.sqrt(deltaX2 * deltaX2 + deltaY2 * deltaY2);

        return cos;
    }
}
