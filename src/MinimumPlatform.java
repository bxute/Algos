public class MinimumPlatform {

    static int[] arr = {9,  10, 9, 12, 10, 9};
    static int[] dep = {11, 12, 12, 13, 14,14};
    static int[] canStand;
    public static void main(String[] args) {
        canStand = new int[arr.length];
        naiveSolution();
    }

    private static void naiveSolution() {
        // 1 platform is must and it first train will get its space always
        int selectedCount = 0;
        canStand[selectedCount] = 0;
        p("In Series 0");
        // we will check for trains which can run in series or say no collapse in their time
        // so Max Required Platform : Total Running Trains - (No Collapsing trains) + 1

        for(int i =1 ;i<arr.length;i++){

            if(arr[i]>=dep[selectedCount]){
                p("In Series "+i);
                canStand[selectedCount++] = i;
            }
        }

        p("Can stand In series :"+ (selectedCount+1));
        p("Platform Req : "+(arr.length-selectedCount));

    }

    private static void p(String s) {
        System.out.println(s);
    }

}
