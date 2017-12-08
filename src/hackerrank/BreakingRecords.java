package hackerrank;

//Problem statement at : https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

public class BreakingRecords {

    private static int[] getBreaks(int[] scores){

        int max = scores[0];
        int min = scores[0];
        int b = 0;
        int ub = 0;

        for(int i = 1;i<scores.length;i++){
            if(scores[i]>max){
                max = scores[i];
                b++;
            }else if(scores[i]<min){
                min = scores[i];
                ub++;
            }
        }

        return new int[]{b,ub};

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    private static void p(String s) {
        System.out.println(s);
    }

}
