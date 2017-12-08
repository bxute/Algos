package codality;

import java.util.Arrays;

public class MinAbsSumOfTwo {

    static int min = Integer.MAX_VALUE;

    private static int findMinAbs(int[] A){

        Arrays.sort(A);

        int len = A.length;
        int a = 0;
        int b = 0;
        int abs = 0;
        while(a<len){

            p("Comp "+A[a]+" and "+A[b]);
            abs = Math.abs(A[a]+A[b]);
            min = abs<min?abs:min;
            p("Now Min "+min);
            // if A[a]<0 A[b]<0  - advance b till end
            // A[a]>0 then check for same and advance a.
             if(A[a]<0){
                 // advance b till end
                 if(++b==len){
                     p("Reached Last");
                     a++;
                     b=a;
                 }
             }else{
                 p("Advancing A");
                 a++;
                 b=a;
             }
        }
        return min;

    }



    public static void main(String[] args) {

        int[] A = {1,2,3,4,5,6,7,8,9};
        p("Abs Min is : "+String.valueOf(findMinAbs(A)));

    }

    private static void p(String s) {
        System.out.println(s);
    }


}
