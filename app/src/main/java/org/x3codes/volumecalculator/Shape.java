package org.x3codes.volumecalculator;

public class Shape {
    private final int shapeImage;
    private final String shapeName;

    public Shape(int shapeImg, String shapeName) {
        this.shapeImage = shapeImg;
        this.shapeName = shapeName;
    }

    public int getShapeImage() {
        return shapeImage;
    }

    public String getShapeName() {
        return shapeName;
    }
}
