public class SegmentTree {

    /*
    *   Segment Tree:
    *   A Tree Data Structure used to store Information of an Interval.
    *   Information can be:
    *    - Sum Of an Interval
    *    - Max/Min of an Interval
    *    - Avg. Of an Interval
    *    - Product of an Interval etc.
    *
    *    Given the range we can calculate these efficiently.
    *    Without Range we can`t calculate them.
    *
    * */

    static int maxNodes;
    static int[] segmentTree;

    public static void main(String[] args) {

        int[] A = {1, 3, 5, 7, 9, 11};
        int len = A.length;
        // calculate height for calculation of max size
        int height = (int) Math.ceil(Math.log(len) / Math.log(2));
        maxNodes = (int) (2 * Math.pow(2, height) - 1);
        segmentTree = new int[maxNodes];

        constructSegmentTree(A, 0, A.length - 1, 0);

        p("Sum in Range : "+getSum(len,2,5));

    }

    private static int constructSegmentTree(int[] arr, int startIndex, int endIndex, int storeResultAtIndex) {

        // check for the singularity of elements
        if (startIndex == endIndex) {
            // we have single element, store it and return
            segmentTree[storeResultAtIndex] = arr[startIndex];
            printArray(segmentTree);
            return arr[startIndex];
        }

        /*
         *  We have more than one element
         *  So
         *  1 . divide the array into two parts
         *  2 . store the result of both parts into `storeResultAtIndex`
         *  3 . Recur for both parts of array
         *  4 . return the result
         *
         * */

        // calculating middle of array
        int mid = (startIndex + endIndex) / 2;

        /*
         *   We need to calculate the storage location for the next two recur
         *   For first part : loc1 = 2*storeResultAtIndex + 1
         *   For second part: loc2 = 2*storeResultAtIndex + 2
         * */

        int locationForFirstPart = 2 * storeResultAtIndex + 1;
        int locationForSecondPart = 2 * storeResultAtIndex + 2;

        /*
         *   NOTE : This is the core operation which specific to problem statement
         *   For operation over a range of array elements like:
         *    - Sum of range of Elements
         *    - Minimum/Maximum of all in given range
         *    - Minimum/Maximum Average of all in given range etc.
         *
         *   We just need to change the below operation accordingly.
         *   After Respective operation we store them in the Segment tree.
         *
         *  Here we are interested in finding the sum of a range of elements, so we are
         *  summing up the items are storing them. :)
         *
         * */

        //store the result into current Storage Location
        segmentTree[storeResultAtIndex] =
                constructSegmentTree(arr, startIndex, mid, locationForFirstPart) +
                        constructSegmentTree(arr, mid + 1, endIndex, locationForSecondPart);

        // return the result
        printArray(segmentTree);
        return segmentTree[storeResultAtIndex];

    }

    private static int getSumHelper(int startIndex, int endIndex, int queryFrom, int queryTo, int resultStoredAt) {

        /*
         *  Check if the give range is completely inside the segment
         *  Then, return value at resultStoredAt
         * */
        if (startIndex >= queryFrom && endIndex <= queryTo) {
            return segmentTree[resultStoredAt];
        }

        /*
         *  Check if the range is outside the segment
         *  Then return 0
         * */

        if (startIndex > queryTo || endIndex < queryFrom) {
            return 0;
        }

        /*
         * If all the above case misses,It means the range is overlapping with segment
         *  Divide the range and recur to get the sum
         * */
        int mid = (startIndex + endIndex) / 2;

        /*
         *   Find the next locations for result
         *   for first part : loc1 = 2*resultStoredAt +1
         *   for second part :  loc2 = 2*resultStoredAt +2
         * */

        int firstLocation = 2 * resultStoredAt + 1;
        int secondLocation = 2 * resultStoredAt + 2;

        return getSumHelper(startIndex, mid , queryFrom,queryTo,firstLocation)
                +
                getSumHelper(mid+1,endIndex,queryFrom,queryTo,secondLocation);

    }

    private static int getSum(int length , int from, int to){
        // safeguard for ranges
        if(from<0 || to >length-1 || from>to){
            p("Error Input");
        }
        // We start from 0
        return getSumHelper(0,length-1,from,to,0);
    }

    private static void printArray(int[] A) {

        for (int i = 0; i < A.length; i++) {
            System.out.print("[" + A[i] + "]");
        }

        p("");

    }

    private static void p(String s) {
        System.out.println(s);
    }

}
