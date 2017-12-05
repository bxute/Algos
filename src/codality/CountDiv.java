package codality;

/*
*   Problem Statement at : https://codility.com/programmers/lessons/5-prefix_sums/count_div
* */

public class CountDiv {
    public static void main(String[] args) {
        p("Divisors "+countDivisers(0,0,11));
    }

    private static int countDivisers(int A,int B,int K){

        int firstQ = -1;
        int secondQ = -1;
        for(int i = A;i<=B;i++){

                if(i%K==0 || i==0){
                    firstQ = i/K;
                    break;
                }
        }

        for(int i = B;i>=A;i--){

            if(i%K==0 || i==0){
                secondQ = i/K;
                break;
            }
        }
        return (firstQ==-1) || (secondQ==-1) ? 0:secondQ-firstQ+1;

    }


    private static void p(String s) {
        System.out.println(s);
    }

}
