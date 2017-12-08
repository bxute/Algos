package codality;

import java.util.HashMap;

public class Dominator {

    // Problem statement at : https://codility.com/programmers/lessons/8-leader/dominator

    static int maxIndex;
    static int maxCount;
    static HashMap<Integer,Integer> counts;

    private static int getDominator(int[] A){

        int len = A.length;
        counts = new HashMap<>();
        for(int i = 0;i<len;i++){

            counts.put(A[i],counts.getOrDefault(A[i],0)+1);

            if(maxCount<counts.getOrDefault(A[i],0)){
                maxCount = counts.getOrDefault(A[i],0);
                maxIndex = i;
            }

        }

        return maxCount>(len/2)?maxIndex:-1;
    }


    public static void main(String[] args) {
        int[] A = {1,1,1,1,1,1,0,0};
        p("Max Count Index "+getDominator(A));
    }


    private static void p(String s) {
        System.out.println(s);
    }


}
