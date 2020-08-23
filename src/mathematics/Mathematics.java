package mathematics;

/**
 * Created by ponomarevandrew on 03.11.17.
 */
public class Mathematics {

    /**
     * Самая тупая проверка
     */
    public static boolean isPrime(long n) {
        if (n == 1) return false;
        for (long i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Наибольший общий делитель
     * @param a
     * @param b
     * @return Наибольшее число, на которое делится и a, и b
     */
    public static long gcd(long a, long b) {
        return b==0 ? Math.abs(a) : gcd(b, a%b);
    }

    /**
     * Наименьшее общее кратное
     * Наименьшее число, которое делится и на a, и на b
     */
    public static long lcm(long a, long b) {
        return Math.abs(a*b)/gcd(a,b);
    }


    /**
     * Критерий эйлера проверяет является ли число a взаимно квалратичным вычетом по модулю m
     * @param a
     * @param m
     * @return
     */
    public static boolean eulerCriterion(int a, int m) {
        if (m % 2 == 0) {
            return false;
        }
        if (Math.pow(a, (m-1)/2) % m == 1) {
            return true;
        }
        return false;
    }

    /**
     * Факториал
     * @param n
     * @return
     */
    public static int factorial(int n)
    {
        int f=1;
        for(int i=2;i<=n;++i)
            f=f*i;
        return f;
    }

    /**
     * Число сочетаний из n по k
     * @param n
     * @param k
     * @return
     */
    public static int C(int n, int k)
    {
        return factorial(n)/factorial(k)/factorial(n-k);
    }

}
