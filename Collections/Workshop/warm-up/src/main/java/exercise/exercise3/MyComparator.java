package exercise.exercise3;

import java.util.Comparator;

/**
 * Created by user on 01.07.2016.
 */
public class MyComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        return ((String)o1).length() - ((String)o2).length();
    }
}
