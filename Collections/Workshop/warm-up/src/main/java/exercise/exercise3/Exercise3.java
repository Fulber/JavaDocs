package exercise.exercise3;

import java.util.*;

/**
 * Created by Radu.Hoaghe on 04/20/2015.
 *
 * Exercise 3: Fill three Set implementations that you know (Hint: they were described during
 *             the earlier presentation) with the List<String> that is given to this class by
 *             its constructor.
 *
 *             Check out the elements that the list mentioned above contains and then, add them
 *             to your three Sets. After this check out the elements of your Sets. What do you
 *             remark? What could be the reason?
 *
 *             Finally, add to the one of the three Sets some elements
 *             that already exist in the Set (e.g add("that") and add("collection"))
 *
 *             To run your implementation, run the Exercise3Test class.
 */
public class Exercise3 {

    // List containing some elements that need to be added into the Set
    private List<String> listToAdd;

    public Exercise3(List<String> l) {
        listToAdd = l;
    }

    public void addElementsToSets(){

        System.out.println("The elements that will be added to the Sets: ");
        // TODO Exercise #3 a) Check the content of the elements you will add into the Set
        for (String string : listToAdd) {
            System.out.print(string +" ");
        }
        System.out.println();

        // TODO Exercise #3 b) add the elements from listToAdd to the Sets
        Set<String> hashSet = new HashSet<String>(listToAdd);
        Set<String> treeSet = new TreeSet<String>(listToAdd);
        Set<String> linkedHashSet = new LinkedHashSet<String>(listToAdd);

        Comparator<String> myComparator = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        // TODO Exercise #3 c) Check the content of the Sets
        System.out.println("\nThe elements contained in the first Set: ");
        System.out.println(hashSet.toString());

        System.out.println("\nThe elements contained in the second Set: ");
        System.out.println(treeSet.toString());

        System.out.println("\nThe elements contained in the third Set: ");
        System.out.println(linkedHashSet.toString());


        treeSet.add(listToAdd.get(2));
        treeSet.add(listToAdd.get(2));
        System.out.println("\nThe elements contained in the TreeSet after inserting two duplicates: ");
        System.out.println(treeSet.toString());

        // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        // TODO Exercise #3 d) and print again the TreeSet. What do you see?

        TreeSet<String> myTreeSet = new TreeSet<String>(new MyComparator());
        myTreeSet.addAll(listToAdd);
        System.out.println("\nThe elements contained in the TreeSet with custom comparator: ");
        System.out.println(myTreeSet.toString());
    }
}