// import java.util.*;
// public class LL {
//     public static void main(String[] args) {
//         List<Integer> list = new LinkedList<Integer>();
//         list.add(5);
//         list.add(10);
//         list.add(2);
//         // list.peekFirst();  //It is used in "LinkedList" parent approach 
//         System.out.println(list.remove(3));

//     }
// }

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LL {
    public static void main(String[] args) {
        // Sample ArrayList with nested lists
        ArrayList<List<Integer>> nestedList = new ArrayList<>();
        nestedList.add(new ArrayList<>(List.of(1, 2, 3)));
        nestedList.add(new ArrayList<>(List.of(4, 5, 6)));
        nestedList.add(new ArrayList<>(List.of(7, 8, 9)));

        // Reverse each inner list
        for (List<Integer> innerList : nestedList) {
            Collections.reverse(innerList);
        }

        // Reverse the order of outer list
        Collections.reverse(nestedList);

        // Print the reversed nested list
        for (List<Integer> innerList : nestedList) {
            System.out.println(innerList);
        }
    }
}
