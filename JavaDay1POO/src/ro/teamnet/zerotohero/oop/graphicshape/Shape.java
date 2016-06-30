package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 30.06.2016.
 */
public class Shape extends AbstractClass implements ShapeBehaviour {

    protected int color;
    protected float saturation;

    public double area() {

        return 0;
    }

    public int getColor() {
        return this.color;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }
}
