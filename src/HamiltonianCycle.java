public class HamiltonianCycle {

    static int[][] graph = {
            {1, 1, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 0, 1},
            {1, 1, 0, 1, 1},
            {0, 1, 1, 1, 1}};

    static int[] visited;

    public static void main(String[] args) {
        visited = new int[5];

        for (int i = 0; i < 5; i++) {
            visited[i] = 0;
        }

        move(0);

    }

    private static boolean move(int x) {

        if (x == 0 && allVisited()) {
            p("Reached " + x);
            return true;
        }

        for (int i = 0; i < 5; i++) {
            if (i == x)
                continue;

            if (canWeMoveTo(x, i)) {
                p("Moving to  " + i);
                int s = move(i) ? 1 : 0;
                if (s == 1) {
                    p("Moved to " + i);
                    setVisited(i);
                }
            }
        }
        return false;
    }

    private static void setVisited(int x) {
        visited[x] = 1;
    }

    private static boolean canWeMoveTo(int x, int y) {
        p("Checking for " + graph[x][y] + " At :[" + x + "][" + y + "]");
        return visited[y] == 0 && graph[x][y] == 1;
    }

    private static boolean allVisited() {

        int p = 1;
        for (int i = 0; i < 5; i++) {
            p *= visited[i];
        }
        return p == 1;

    }

    private static void p(String s) {
        System.out.println(s);
    }

}
