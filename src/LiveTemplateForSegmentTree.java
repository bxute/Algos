public class LiveTemplateForSegmentTree {

    static int[] segmentTree;

    public static void main(String[] args) {
        // test data
        int[] A = {1, 3, 5, 7, 9, 11};
        int len = A.length;
        // calculate height for calculation of max size
        int height = (int) Math.ceil(Math.log(len) / Math.log(2));
        int maxNodes = (int) (2 * Math.pow(2, height) - 1);
        segmentTree = new int[maxNodes];
        constructSegmentTree(A, 0, A.length - 1, 0);

    }

    private static int constructSegmentTree(int[] arr, int startIndex, int endIndex, int storeResultAtIndex) {

        if (startIndex == endIndex) {
            segmentTree[storeResultAtIndex] = arr[startIndex];
            return arr[startIndex];
        }

        int mid = (startIndex + endIndex) / 2;
        int locationForFirstPart = 2 * storeResultAtIndex + 1;
        int locationForSecondPart = 2 * storeResultAtIndex + 2;

        //TODO: Change this according to your problem statement
        segmentTree[storeResultAtIndex] =
                constructSegmentTree(arr, startIndex, mid, locationForFirstPart) +
                        constructSegmentTree(arr, mid + 1, endIndex, locationForSecondPart);

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

        //TODO: Change this according to your problem statement
        return getOperationHelper(startIndex, mid, queryFrom, queryTo, firstLocation)
                +
                getOperationHelper(mid + 1, endIndex, queryFrom, queryTo, secondLocation);

    }

    private static int getOperationResult(int length, int from, int to) {
        if (from < 0 || to > length - 1 || from > to) {
            System.out.print("Error Input");
        }
        return getOperationHelper(0, length - 1, from, to, 0);
    }


}
