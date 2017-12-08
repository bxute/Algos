package codality;

public class MinAvgTwoSlice {

    private static int av1;
    private static int av2;

    // Problem Statement at  : https://codility.com/programmers/lessons/5-prefix_sums/genomic_range_query

    public static void main(String[] args) {
        int[] P = {4, 2, 2, 5, 1, 5, 8};

        p("Average :" + getMinimumAvg(P));

    }

    static int[] segmentTree;
    static int minAvg = 99999999;
    static int index = -1;

    private static int getMinimumAvg(int[] P) {

        int len = P.length;
        // calculate height for calculation of max size
        int height = (int) Math.ceil(Math.log(len) / Math.log(2));
        int maxNodes = (int) (2 * Math.pow(2, height) - 1);
        segmentTree = new int[maxNodes];

        constructSegmentTree(P, 0, len - 1, 0);

        return getOperationResult(len, 0, len - 1);

    }

    private static int constructSegmentTree(int[] arr, int startIndex, int endIndex, int storeResultAtIndex) {

        if (startIndex == endIndex) {
            segmentTree[storeResultAtIndex] = arr[startIndex];
            printArray(segmentTree);
            return arr[startIndex];
        }

        int mid = (startIndex + endIndex) / 2;
        int locationForFirstPart = 2 * storeResultAtIndex + 1;
        int locationForSecondPart = 2 * storeResultAtIndex + 2;

        // Store average of both
        segmentTree[storeResultAtIndex] =
                constructSegmentTree(arr, startIndex, mid, locationForFirstPart)
                +
                constructSegmentTree(arr, mid + 1, endIndex, locationForSecondPart);


        printArray(segmentTree);
        return segmentTree[storeResultAtIndex];

    }

    private static int getOperationHelper(int startIndex, int endIndex, int queryFrom, int queryTo, int resultStoredAt) {

        if (startIndex >= queryFrom && endIndex <= queryTo) {
            return segmentTree[resultStoredAt];
        }

        if (startIndex > queryTo || endIndex < queryFrom) {
            return 0;
        }

        int mid = (startIndex + endIndex) / 2;

        int firstLocation = 2 * resultStoredAt + 1;
        int secondLocation = 2 * resultStoredAt + 2;

        return getMin(
                getOperationHelper(startIndex, mid, queryFrom, queryTo, firstLocation),
                getOperationHelper(mid + 1, endIndex, queryFrom, queryTo, secondLocation)
        );

    }

    private static int getMin(int a, int b) {

        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if (a > b) {
            return b;
        } else {
            return a;
        }

    }

    private static int getOperationResult(int length, int from, int to) {
        if (from < 0 || to > length - 1 || from > to) {
            System.out.print("Error Input");
        }
        return getOperationHelper(0, length - 1, from, to, 0);
    }

    private static void p(String s) {
        System.out.println(s);
    }

    private static void printArray(int[] A) {

        for (int i = 0; i < A.length; i++) {
            System.out.print("[" + A[i] + "]");
        }
        p("");
    }

}
