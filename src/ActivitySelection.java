public class ActivitySelection {

    /* GREEDY ALGORITH
     * At every step, we can make a choice that looks best at the moment,
     * and we get the optimal solution of the complete problem.
     * */

    static int[][] activities = {{9, 11}, {10, 12}, {9, 12}, {11, 13}, {10, 14}, {11, 14}, {9, 14}};
    static int[] selected;

    public static void main(String[] args) {
        selected = new int[activities.length];
        select();
    }

    private static void select() {

        // first is always the best option
        int ind = 0;
        selected[ind] = 0;
        p("Act:{" + activities[0][0] + "}{" + activities[0][1] + "}");

        for (int i = 1; i < activities.length; i++) {
            // if current activity`s start time is greater than or equal to
            // finish time of last selected activity then -> select
            if (activities[ind][1] <= activities[i][0]) {
                p("Act:{" + activities[i][0] + "}{" + activities[i][1] + "}");
                selected[ind++] = i;
            }

        }

    }

    private static void p(String s) {
        System.out.println(s);
    }


}
