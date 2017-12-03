public class MinimumChange {

    /* GREEDY ALGORITH
     * At every step, we can make a choice that looks best at the moment,
     * and we get the optimal solution of the complete problem.
     * */

    static int[] denominations = {1000, 500, 100, 50, 20, 10, 5, 2, 1};

    public static void main(String[] args) {
        makeChange(3213);
    }

    private static void makeChange(int amount) {
        int header = 0;
        while (amount > 0) {
            if (amount >= denominations[header]) {
                p("[" + denominations[header] + "]");
                amount -= denominations[header];
            } else {
                header++;
            }
        }
    }

    private static void p(String s) {
        System.out.print(s);
    }

}
