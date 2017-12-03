import java.util.ArrayList;

public class PatternMatch {

    static String text = "ThisIsaTestString";
    static int[] foundIndexes;

    public static void main(String[] args) {

        foundIndexes = new int[5];
        findPattern("in");
    }

    private static void findPattern(String match) {

        char[] store = text.toCharArray();
        char[] chars = match.toCharArray();
        int ind = 0;
        // loop for each index
        for(int i = 0;i<=store.length-chars.length;i++){
            //match now - if found add index to foundIndexes
            boolean misMatchFound = false;
            for(int j=0;j<chars.length;j++){
                if(store[i+j]!=chars[j]) {
                    misMatchFound = true;
                    break;
                }
            }
            if(!misMatchFound){
                p("Found at Ind :"+i);
                foundIndexes[ind++] = i;
            }
            // else slide(advance the loop)
        }

    }

    private static void p(String s) {
        System.out.println(s);
    }


}
