import java.util.*;

public class TestDeque {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        System.out.println("Enter 2 Integers for size of array and subarray");
        int n = input.nextInt();
        int m = input.nextInt();
        int res = 0;

        System.out.println("Enter Integers for array of length: " + n);

        for ( int i = 0; i < n; i++ ) {

            int num = input.nextInt();
            deque.addLast(num);

            if ( map.containsKey(num)) {
                map.put(num, map.get(num).intValue() + 1);
            } else {
                map.put(num, 1);
            }

            if (deque.size() == m + 1) {
                int key = deque.removeFirst();
                int v = map.get(key);

                if (v == 1) {
                    map.remove(key);
                } else {
                    map.put(key, v - 1);
                }
            }

            int cnt = map.size();
            if ( cnt > res ) {
                res = cnt;
            }
        }
        System.out.println("Number of unique Integers in sub arrays : " + res);
    }
}
