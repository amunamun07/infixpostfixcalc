package com.example.amuntimilsina.f1soft.InfixToPostfix;

public class ValueStack {

    static int MAX = 100;
    static int topOfStack;
    static String[] a = new String[MAX]; // Maximum size of Stack
    static int i;
    static int j=0;
    static String exp;
    static String[] post = new String[MAX];
    static String t;


    public static void Vstackinit(){
        topOfStack = -1;
    }




    public static void PostfixConversion(String exp) {

         if (exp == "(") {

             Push(exp);

         } else if (isOperand(exp)) {

             post[j] = exp;
//            System.out.println(j+":"+post[j]);
             j++;
         } else if (isOperator(exp)) {

             t = pop();
             while (isOperator(t) && (precedence(t) >= precedence(exp))) {
                 post[j] = t;
//                   System.out.println(j+":"+post[j]);
                 j++;
                 t = pop();
             }
             Push(t);
             Push(exp);

         } else if (exp.equals(")")) {
             t = pop();

             while (!t.equals("(")) {
                 post[j] = t;
//                    System.out.println(j+":"+post[j]);
                 j++;
                 t = pop();
             }

         }else if(exp.equals("")) {
                post[j] = "\0";

         }else {
             System.out.println("Invalid Expression");
         }
     }


    private static boolean isOperand(String exp){

        if(!exp.equals(null) && !exp.equals("") && Character.isDigit(exp.charAt(0))) {
            return true;
        }else{
            return false;
        }

    }

    private static boolean isOperator(String exp){

        if(exp != null && (exp.equals("^") || exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/")))
            return true;
        else
            return false;
    }





    private static int precedence(String exp) {

        if(exp.equals("^"))
            return (3);
        else if(exp.equals("*") || exp.equals("/"))
            return (2);
        else if(exp.equals("+") || exp.equals("-"))
            return (1);
        else
            return (0);

    }

    private static String pop() {

         if(topOfStack != -1){
             String x = a[topOfStack];
             topOfStack--;
             return x;
         }
         else {
             return "Stack is empty";
         }


    }

    private static void Push(String x) {

        if(topOfStack > MAX -1)
            System.out.println("OverFlow Stack!");
        else{
            topOfStack++;
            a[topOfStack] = x;
        }

    }

    public static void PopTheRemainingStack() {
        while(topOfStack > 0){
            post[j]=pop();
//            System.out.println(j+":"+post[j]);
            j++;
        }
        post[j] ="\0";
    }



    public static String getPostfixString(int j) {

        if(isOperator(post[j]) || isOperand(post[j])){
            String x = post[j];
            pop();
            return x;

        }else {
            return "invalid";
        }

    }

    public static void ClearVStach(){

        while(topOfStack != -1){
            pop();
        }
        while(j!=0){
            j--;
        }
    }







}

