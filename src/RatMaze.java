public class RatMaze {

    /*
     maze of a rat
     1 represent path
     0 represent blocked cell
     Destination is [5][5](last corner)
     */
    static int[][] maze = {
            {1, 1, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1}};

    static int[][] path;
    static int[][] visited;
    static int DIMENSION = 5;

    public static void main(String[] args) {

        path = new int[DIMENSION][DIMENSION];
        visited = new int[DIMENSION][DIMENSION];

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                path[i][j] = 0;
                visited[i][j] = 0;
            }
        }
        //initial position of rat
        path[0][0] = 1;
        visited[0][0] = 1;
        String msg = move(0, 0) ? "Destination Reached" : "No Path found!";
        p(msg);
        showPath();

    }

    private static boolean move(int x, int y) {

        //final destination
        if (x == DIMENSION - 1 && y == DIMENSION - 1) {
            p("Destination");
            return true;
        }

        // move forward
        if (canMoveTo(x + 1, y)) {
            //p("Moving to x=" + (x + 1) + " y=" + y);
            visited[x + 1][y] = 1;
            int is = move(x + 1, y) ? 1 : 0;
            path[x + 1][y] = is;
            if (is == 1) {
                return true;
            }
        }

        // move down
        if (canMoveTo(x, y + 1)) {
            //p("Moving to x=" + (x) + " y=" + (y + 1));
            visited[x][y + 1] = 1;
            int is = move(x, y + 1) ? 1 : 0;
            path[x][y + 1] = is;
            if (is == 1)
                return true;
        }

        // move left
        if (canMoveTo(x - 1, y)) {
            //p("Moving to x=" + (x - 1) + " y=" + y);
            visited[x - 1][y] = 1;
            int is = move(x - 1, y) ? 1 : 0;
            path[x - 1][y] = is;
            if (is == 1)
                return true;
        }

        return false;

    }

    private static void showPath() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print("[" + path[i][j] + "]");
            }
            System.out.println("");
        }
    }

    private static boolean canMoveTo(int x, int y) {

        if (x >= 0 && y >= 0 && x <= DIMENSION - 1 && y <= DIMENSION - 1) {
            return (maze[x][y] != 0) && visited[x][y] == 0;
        } else {
            return false;
        }
    }
    
    private static void p(String s) {
        System.out.println(s);
    }

}
