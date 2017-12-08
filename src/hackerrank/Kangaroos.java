package hackerrank;

// Problem statement at : https://www.hackerrank.com/challenges/kangaroo/problem

public class Kangaroos {

    private static String willTheyLandAtSamePlace(int x1,int v1,int x2,int v2){

        if(v1==v2){
            return x1==x2?"YES":"NO";
        }

        int value = Math.abs(x1-x2)%Math.abs(v2-v1);
        p("Mod " + value);
        return ( value==0 && ((x1>x2 && v2>v1) || (x1<x2 && v2<v1)) )?"YES":"NO";
    }

    public static void main(String[] args) {

        System.out.println("Answer "+willTheyLandAtSamePlace(6644, 5868, 8349, 3477));

    }

    private static void p(String s) {
        System.out.println(s);
    }

}
