package codality;

/*
*  Problem Statement at : https://codility.com/programmers/lessons/4-counting_elements/max_counters
* */
public class MaxCounters {

    static int[] counters;
    static int max = 0;
    static int lastIndex = 0;
    static int base = 0;

    public static void main(String[] args) {

        int[] A = {3,4,4,6,1,4,4};
        int N = 5;
        processCounter(A,N);

    }

    private static void processCounter(int[] A,int N){

        counters = new int[N];
        for(int i = 0;i<A.length;i++){
            lastIndex = i;

            if(A[i]==N+1){
                maxCounter();
            }else{
                increaseCounter(A[i]-1);
            }
        }
        postProcessCounters();
        printCounter(N);

    }

    private static void postProcessCounters() {
        for(int i = 0;i<counters.length;i++){
            counters[i] = counters[i]<base?base:counters[i];
        }
    }

    private static void printCounter(int N){
        for(int i = 0;i<N;i++){
            System.out.print(counters[i]+" ");
        }
        p("");
    }

    private static void increaseCounter(int index){


        if(base>counters[index]) {
            // if base if greater than current counter value
            // increment counter from base
            counters[index] = base + 1;
        }else{
            // if current value if greater than the base, increment by 1
            counters[index]+=1;
        }

        max = counters[index]> max ?counters[index]: max;

    }

    private static void maxCounter(){
        // reset the max
        base = max;
    }

    private static void p(String s) {
        System.out.println(s);
    }


}

