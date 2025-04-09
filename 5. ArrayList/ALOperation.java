import java.util.ArrayList;
import java.util.Collections;

public class ALOperation {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(2);
        list.add(7);
        list.add(10);

        System.out.println("original list:"+ list);
        System.out.println("remove 2");
        list.remove(1);
        System.out.println(list);

        System.out.println("insert 2 at index 2");
        list.add(1, 2);
        System.out.println(list);

        System.out.println("replace 2 with 4");
        list.set(1, 4);
        System.out.println(list);

        System.out.println("list contains 4: "+ list.contains(4));
        System.out.println("list contains 2: "+ list.contains(2));

        System.out.println("size of list: "+ list.size());

        System.out.println("Sort list");
        Collections.sort(list);
        System.out.println(list);

        System.out.println("Sort list in decsending order");
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

    }
}
