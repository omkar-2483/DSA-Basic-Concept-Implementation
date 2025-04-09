import java.util.LinkedList;
import java.util.Queue;
public class QueueJCF {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        
        System.out.println(q);
        q.add(1);
        System.out.println(q);
        q.add(2);
        System.out.println(q);
        q.add(3);
        System.out.println(q);
        q.remove();
        System.out.println(q);
        q.remove();
        System.out.println(q);
        q.remove();
        System.out.println(q);
        q.remove();
        System.out.println(q);
    }
}
