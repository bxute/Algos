public class SpiralMatrix {

    // marker for left corner
    static int leftHead = -1;
    // marker for right corner
    static int rightHead = -1;
    // marker for bottom corner
    static int bottomHead = -1;
    // marker for top corner
    static int topHead = -1;

    static int[][] arr = {
            {1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}};

    public static void main(String[] args) {

        // init heads
        topHead = -1;
        rightHead = arr.length;
        bottomHead = arr.length;
        leftHead = -1;

        // starting from top-left corner
        print(0, 0, 0);

    }

    private static void print(int startX, int startY, int dir) {
        // dir(directions) can be [0,1,2,3]
        int _d = dir % 4;

        if (_d == 0) {
            //print row to right
            if (startX == rightHead)
                return;

            while (startX < rightHead) {
                p(String.valueOf(arr[startY][startX]));
                startX++;
            }
            topHead++;
            dir++;
            print(startX - 1, startY + 1, dir);

        } else if (_d == 1) {
            // print top to down
            if (startY == bottomHead)
                return;

            while (startY < bottomHead) {
                p(String.valueOf(arr[startY][startX]));
                startY++;
            }
            rightHead--;
            dir++;
            print(startX - 1, startY - 1, dir);

        } else if (_d == 2) {
            // print right to left
            if (startX == leftHead)
                return;

            while (startX > leftHead) {
                p(String.valueOf(arr[startY][startX]));
                startX--;
            }
            bottomHead--;
            dir++;
            print(startX + 1, startY - 1, dir);

        } else {
            // print bottom to top
            if (startY == topHead)
                return;

            while (startY > topHead) {
                p(String.valueOf(arr[startY][startX]));
                startY--;
            }
            leftHead++;
            dir++;
            print(startX + 1, startY + 1, dir);

        }
    }

    private static void p(String s) {
        System.out.println(s);
    }
}
