import java.util.*;

public class Sol2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double[] arr = new double[n];
        double[] helpArr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextDouble();
            helpArr[i] = -1.0;
        }
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scan.nextInt();
            int k = scan.nextInt();
            //System.out.println(meanGeom(arr, helpArr, l, k));
        }
    }



}
