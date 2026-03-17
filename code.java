import java.util.*;

public class Solution {

    public static long maximumSum(long[] a, long m) {
        TreeSet<Long> set = new TreeSet<>();
        long prefix = 0;
        long max = 0;

        set.add(0L);

        for (long val : a) {

            prefix = (prefix + val % m) % m;

            max = Math.max(max, prefix);

            Long next = set.higher(prefix);

            if (next != null) {
                max = Math.max(max, (prefix - next + m) % m);
            }

            set.add(prefix);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        while (q-- > 0) {
            int n = sc.nextInt();
            long m = sc.nextLong();

            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            System.out.println(maximumSum(a, m));
        }

        sc.close();
    }
}
