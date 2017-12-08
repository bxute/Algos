package hackerrank;

// Problem statement at : https://www.hackerrank.com/challenges/grading/problem

public class GradingStudent {

    private static int[] getGrades(int[] grades){

        for(int i = 0;i<grades.length;i++){
            grades[i] = getNewGrade(grades[i]);
        }
        return grades;

    }

    private static int getNewGrade(int grade){

        if(grade<38){
            return grade;
        }

        if((((5-grade%5)+grade) - grade)<3){
            return  (5-grade%5)+grade;
        }

        return grade;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    private static void p(String s) {
        System.out.println(s);
    }

}
