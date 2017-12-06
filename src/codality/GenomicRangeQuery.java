package codality;

public class GenomicRangeQuery {



    public static void main(String[] args) {
        String s = "CAGCCTA";
        int[] P = {2,5,0};
        int[] Q = {4,5,6};

        p("Max of Them :");
        printArray(getMinimumImpactFactor(s,P,Q));
    }

    static int[] segmentTree;

    private static int[] getMinimumImpactFactor(String S, int[] P, int[] Q){

        int[] result = new int[Q.length];
        int len = S.length();
        int[] A = new int[len];

        for(int i = 0;i<len;i++){
            switch (S.charAt(i)){
                case 'A':
                    A[i] = 1;
                    break;
                case 'C':
                    A[i] = 2;
                    break;
                case 'G':
                    A[i] = 3;
                    break;
                case 'T':
                    A[i] = 4;
                    break;
            }
        }
        // calculate height for calculation of max size
        int height = (int) Math.ceil(Math.log(len) / Math.log(2));
        int maxNodes = (int) (2 * Math.pow(2, height) - 1);
        segmentTree = new int[maxNodes];

        constructSegmentTree(A, 0, A.length - 1, 0);

        for(int i = 0;i<P.length;i++){
            result[i] = getOperationResult(len,P[i],Q[i]);
        }

        return result;
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

        // Store minimum of both
        segmentTree[storeResultAtIndex] = getMin(
                constructSegmentTree(arr, startIndex, mid, locationForFirstPart),
                constructSegmentTree(arr, mid + 1, endIndex, locationForSecondPart)
        );

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

    private static int getMin(int a, int b){

        if(a==0)
            return b;
        if(b==0)
            return a;

        if(a>b){
            return b;
        }else{
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
