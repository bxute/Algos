package hackerrank;


// Problem Statement at :  https://www.hackerrank.com/challenges/apple-and-orange/problem

public class AppleAndOrange {

    private static int getApples(int a,int s,int t,int[] A){
        int sum = 0;
        for(int i = 0;i<A.length;i++){
            sum+=(a+A[i])>=s && (a+A[i])<=t ? 1:0;
        }
        return sum;
    }

    private static int getOranges(int b, int s, int t, int[] O){
        int sum = 0;
        for(int i = 0;i<O.length;i++){
            sum+=(b+O[i])>=s && (b+O[i])<=t ? 1:0;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println();
    }

    private static void p(String s) {
        System.out.println(s);
    }

}
