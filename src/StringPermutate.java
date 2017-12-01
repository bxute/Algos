public class StringPermutate {

    public static void main(String[] args) {
        permutate("ABC",0,2);
    }

    private static void permutate(String s , int start , int end){
        if(start==end){
            p(s);
        }
        for(int i = start;i<=end;i++){
            s = swap(s,start,i);
            permutate(s,start+1,end);
            s = swap(s,start,i);
        }
    }

    private static String swap(String s, int i, int j) {

        char temp;
        char[] chars = s.toCharArray();
        temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);

    }

    private static void p(String s){
        System.out.println(s);
    }

}
