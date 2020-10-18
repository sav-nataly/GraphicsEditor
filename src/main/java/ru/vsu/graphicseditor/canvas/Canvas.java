package ru.vsu.graphicseditor.canvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ru.vsu.graphicseditor.shape.Shape;

public class Canvas {
    private int width;
    private int height;

    private List<Layer> layerList = new ArrayList<>();
    private int currentLayer = 0;

    public Canvas(int width, int height, Color backgroundColor) {
        this.width = width;
        this.height = height;
        layerList.add(new Layer(backgroundColor, 0));
    }

    public Canvas(int width, int height, Color backgroundColor, List<Layer> layerList) {
        this.width = width;
        this.height = height;
        this.layerList = layerList;
        layerList.add(new Layer(backgroundColor, 0));
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        layerList.add(new Layer((Color) null, 0));
    }

    public Canvas(){}

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Layer> getLayerList() {
        return layerList;
    }

    public void setLayerList(List<Layer> layerList) {
        this.layerList = layerList;
        currentLayer = layerList.size();
    }

    public int getCurrentLayerNumber() {
        return currentLayer;
    }

    public Layer getCurrentLayer(){
        return layerList.get(currentLayer);
    }

    public void setCurrentLayer(int currentLayer) {
        this.currentLayer = currentLayer;
    }

    public void addNewLayer(){
        layerList.add(currentLayer  + 1, new Layer(layerList.size()));
        currentLayer++;
    }

    public void addShapeLayer(Layer layer) {
        layerList.add(currentLayer + 1, layer);
        currentLayer++;
    }

    public void addLayers(List<Layer> layers){
        layerList.addAll(currentLayer + 1 , layers);
        currentLayer += layers.size();
    }

    public void moveLayer(int index1, int index2) {
        if (Math.abs(index1 - index2) == 1) {
            Collections.swap(layerList, index1, index2);
        }
        else {
            Layer layer = layerList.remove(index1);
            layerList.add(index2, layer);
        }
    }

    public void deleteLayer(int index) {
        if (layerList.size() > 1) {
            layerList.remove(index);
        }
    }

    public void renameLayer(int index, String name){
        layerList.get(index).setName(name);
    }

    public void combineLayers(int index1, int index2) {
        layerList.get(index1).getShapes().addAll(layerList.get(index2).getShapes());
        layerList.remove(index2);
        if (index1 > index2) currentLayer = index1 - 1;
        else currentLayer = index1;
    }
}
