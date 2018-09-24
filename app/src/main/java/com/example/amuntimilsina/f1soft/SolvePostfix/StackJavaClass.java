package com.example.amuntimilsina.f1soft.SolvePostfix;

public class StackJavaClass {

    static int MAX = 100;
    static int tOS;
    static int[] a = new int[MAX]; // Maximum size of Stack
    static int x1;
    static int x2;
    static int r;
    static String x;

    public static void Stackinitilization(){
        tOS = -1;
    }

    public static void push(String s){


        if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
            x1 = Integer.parseInt(pop());
            x2 = Integer.parseInt(pop());
            switch(s){
                case "+":
                    push(String.valueOf(x1+x2));
                    break;
                case "-":
                        if(x2>x1)
                            push(String.valueOf(x2-x1));
                        else
                            push(String.valueOf(x1-x2));
                    break;
                case "*":
                    push(String.valueOf(x1*x2));
                    break;
                case "/":
                    if(x1 == 0)
                        push(String.valueOf(00000000));
                    else
                        push(String.valueOf(x2/x1));
                    break;
            }
        }else if(isOperand(s)) {
            tOS++;
            a[tOS] = Integer.parseInt(s);


        }
    }

    private static boolean isOperand(String exp){

        if(Character.isDigit(exp.charAt(0))) {
            return true;
        }else{
            return false;
        }

    }

    public static String pop(){

        x = String.valueOf(a[tOS]);
        tOS--;
        return x;

    }


    public static int FinalOutput() {

        int x = a[tOS];
        tOS--;
        while (tOS != -1){
            pop();
        }
        return x;
    }

}
