package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 30.06.2016.
 */
public class Point {

    int xPos;
    int yPos;

    public Point(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null)
            return false;

        if(obj instanceof Point) {
            Point anotherPoint = (Point) obj;
            if( (xPos == anotherPoint.xPos) && (yPos == anotherPoint.yPos) )
                return true;
        }
        return false;
    }
}
