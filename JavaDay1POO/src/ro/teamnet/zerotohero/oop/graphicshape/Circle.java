package ro.teamnet.zerotohero.oop.graphicshape;

import java.lang.Math;

/**
 * Created by user on 30.06.2016.
 */
public class Circle extends Shape {

    private int xPos;
    private int yPos;
    private int radius;

    public Circle() {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 10;
    }

    public Circle(int xPos) {
        this();
        this.xPos = xPos;
    }

    public Circle(int xPos, int yPos) {
        this();
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public String toString() {
        return "center = (" + this.xPos + ", " + this.yPos + ")" + "and radius = " + this.radius;
    }

    public void fillColour() {
        System.out.println(super.getColor());
    }

    public void fillColour(int aColor) {
        super.setColor(aColor);
        System.out.println("The circle color is now " + aColor);
    }

    public void fillColour(float aSaturation) {
        super.setSaturation(aSaturation);
        System.out.println("The circle color saturation is " + aSaturation);
    }
}
