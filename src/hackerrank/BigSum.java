package hackerrank;

public class BigSum {

    private static long getBigSum(int[] A) {
        int len = A.length;
        long sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += A[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] A = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
        p("Sum " + getBigSum(A));

    }

    private static void p(String s) {
        System.out.println(s);
    }


}
