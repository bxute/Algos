package hackerrank;

public class DiagonalDifff {

    private static int getAbsDiff(int[][] A){

        int len = A.length;
        int sum1 = 0;
        int sum2 = 0;

        int x = len-1; // x will go x--
        int y = 0; // y will go y++

        for(int i = 0;i<len;i++){
            sum1+=A[i][i];
            sum2+=A[x--][y++];
        }

        return Math.abs(sum1-sum2);

    }

    public static void main(String[] args) {

        int[][] A = {
                {3,4,5},
                {3,7,5},
                {9,5,1}};

        p(String.valueOf(getAbsDiff(A)));

    }

    private static void p(String s) {
        System.out.println(s);
    }


}

