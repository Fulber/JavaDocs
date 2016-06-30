package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 30.06.2016.
 */
public class Circles {

    public double getAreaPub() {

        Shape circle = new Circle();

        return circle.area();
    }

    public void getAreaDef() {

        Circle circle = new Circle();

        circle.fillColour();
        circle.fillColour(2);
        circle.fillColour(0.2f);
    }
}
