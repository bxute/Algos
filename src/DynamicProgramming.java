public class DynamicProgramming {
    static int[] lookup;
    static final int MAX = 500;
    static final int NIL = -1;

    // Driver code
    public static void main(String[] args) {

//        findLongestIncreasingSequence(new int[]{50,3,10,7,40,80});
        String t1 = "Ankitr";
        String t2 = "AnkitKumar";
        char[] s1 = t1.toCharArray();
        char[] s2 = t2.toCharArray();

        p("LCS = " + String.valueOf(findLCS(s1, s2, t1.length(), t2.length())));

    }

    // helper method for initializing lookup table
    private static void prepareLookup() {
        lookup = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            lookup[i] = NIL;
        }
    }

    // method to calculate fibonaci with DP paradigm in top to bottom approach
    private static int fibTopDown(int n) {
        //first check for the existing solution
        if (lookup[n] == NIL) {
            // calculate the solution and save
            //handle the root value
            if (n <= 1) {
                lookup[n] = n;
            } else {
                // calculate further
                lookup[n] = fibTopDown(n - 1) + fibTopDown(n - 2);
                p("Calculated " + lookup[n] + " for " + (n - 1) + "  " + (n - 2));
            }

        }
        return lookup[n];
    }

    // method to calculate fibonaci with DP paradigm in bottom to top approach
    private static int fibBottomTop(int n) {

        int f[] = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f[n];

    }

    // method to find the longest increasing sequence in a given array of integers
    private static void findLongestIncreasingSequence(int[] seq) {

        int[] records = new int[seq.length];
        /*
         *  Let sequence be :  [50,3,10,7,40,80]
         *  We want records as:[2, 4,3, 3,2 ,1]
         *  Here numbers in record represent count of increasing sequence from current index
         * */

        // Init. records as 1
        for (int i = 0; i < seq.length; i++) {
            records[i] = 1;
        }

        for (int i = seq.length - 2; i >= 0; i--) {
            for (int j = i; j < seq.length; j++) {
                // if current item is less than intermediate
                // then take the max of both into record
                if (seq[i] < seq[j]) {
                    records[i] = Math.max(1 + records[j], records[i]);
                }
            }
        }

        // print the solution list
        int curr = 0;
        String s = "";
        for (int i = seq.length - 1; i >= 0; i--) {
            if (records[i] == curr + 1) {
                curr = records[i];
                s = seq[i] + " " + s;
            }
        }
        p(s);

    }

    private static int findLCS(char[] s1, char[] s2, int indexInS1, int indexInS2) {

        if (indexInS1 == 0 || indexInS2 == 0) {
            return 0;
        }

        if (s1[indexInS1 - 1] == s2[indexInS2 - 1]) {
            return 1 + findLCS(s1, s2, indexInS1 - 1, indexInS2 - 1);
        } else {
            return Math.max(findLCS(s1, s2, indexInS1 - 1, indexInS2), findLCS(s1, s2, indexInS1, indexInS2 - 1));
        }

    }

    // helper method to print the string
    private static void p(String s) {
        System.out.println(s);
    }

}
