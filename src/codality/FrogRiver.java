package codality;
public class FrogRiver {

    /*
    * Problem Statement at :  https://codility.com/programmers/lessons/4-counting_elements/frog_river_one
    * */

    public static void main(String[] args) {
        int[] time = {1,3,1,4,7,8,1,2,3,1,4,1,4,5};
        p("Earliest "+getEarliestTime(time,5));
    }

    private static int getEarliestTime(int[] A , int X){
        // x is width of river
        int[] leavesAt = new int[X];
        int blankAvailable = X;

        for(int i=0;i<A.length;i++){

            if(A[i]<=X) {
                //p("Trying  "+A[i]);
                if (leavesAt[A[i] - 1] == 0) {
                  //  p("Adding "+A[i]);
                    leavesAt[A[i] - 1] = 1;
                    blankAvailable -= 1;
                    //p("Blank Available "+blankAvailable);
                    if (blankAvailable == 0) {
                        return i;
                    }
                }

            }
        }
        return -1;
    }

    private static void p(String s) {
        System.out.println(s);
    }

}
