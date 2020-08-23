import java.util.*;

public class Sol {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLong();
        }
        List<Long> newArr = deleteLast(arr);
        System.out.println(newArr.size());
        for (int i = 0; i < newArr.size(); i++) {
            System.out.print(newArr.get(i) + " ");
        }
    }

    public static List<Long> deleteLast(long[] arr) {
//        Set<Long> s = new LinSet<>();
//        List<Long> l = new ArrayList<>();
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if (!s.contains(arr[i])) {
//                s.add(arr[i]);
//            } else {
//                l.add(arr[i]);
//            }
//        }
//        Collections.reverse(l);
//        return l;
        return new ArrayList<>();
    }
}
