package codality;

        /*
         * Problem Statement at : https://codility.com/programmers/lessons/5-prefix_sums/passing_cars
         * */

public class PassingCars {

    public static void main(String[] args) {

        int[] A = {0, 1, 0, 1, 1};
        p("Carss Passing : " + getCars(A));

    }

    private static int getPassingCars(int[] A) {

        int[] inc = new int[A.length];
        int sum = 0;

        for (int i = A.length - 1; i >= 0; i--) {

            if (i < A.length - 1) {

                if (A[i + 1] == 0) {

                    inc[i] = inc[i + 1];
                    sum += inc[i];

                    if (sum > 1000000000) {
                        return -1;
                    }

                } else {
                    inc[i] = 1 + inc[i + 1];
                }

            } else {
                inc[A.length - 1] = 0;
            }

        }

        sum += A[0] == 0 ? inc[0] : 0;

        return sum;
    }

    // Another short solution
    private static int getCars(int[] A) {

        int east_count = 0;
        int cars = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                east_count++;
            } else {
                cars += east_count;
                if(cars>1000000000)
                    return -1;
            }
        }
        return cars;
    }

    private static void p(String s) {
        System.out.println(s);
    }


}
