package hackerrank;

//Problem statement at : https://www.hackerrank.com/challenges/between-two-sets/problem

public class BetweenTwoSets {

    private static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static long gcd(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) result = gcd(result, input[i]);
        return result;
    }

    private static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    private static long lcm(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }

    private static long getCount(long[] a, long[] b) {

        long lcm = lcm(a);
        long gcd = gcd(b);
        p("LCM " + lcm);
        p("GCD " + gcd);
        long sum = 0;
        for (long i = lcm; i <= gcd; i+=lcm) {
            if (gcd % i == 0) {
                p("Found " + i);
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] a = {2,3};
        long[] b = {42,84};
            p("Between "+getCount(a,b));
    }

    private static void p(String s) {
        System.out.println(s);
    }

}
