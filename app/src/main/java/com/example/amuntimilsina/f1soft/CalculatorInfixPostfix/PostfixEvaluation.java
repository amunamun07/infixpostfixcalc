package com.example.amuntimilsina.f1soft.CalculatorInfixPostfix;

import java.util.List;

public class PostfixEvaluation {
     int MAX = 100;
     int tOS;
     String[] a = new String[MAX]; // Maximum size of Stack
     String x;

    public String Evaluate(List<String> e) {

        String cx2;
        String cx1;
        int x1;
        int x2;
        for (String s: e) {


            if ((s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*"))) {

                cx1 = pop();
                cx2 = pop();
                if (cx1 != null && cx2 != null && Character.isDigit(cx1.charAt(0)) && Character.isDigit(cx2.charAt(0))){

                    x1 = Integer.parseInt(cx1);
                    x2 = Integer.parseInt(cx2);
                    switch (s) {
                        case "+":
                            push(String.valueOf(x1 + x2));
                            break;
                        case "-":
                            if (x2 > x1)
                                push(String.valueOf(x2 - x1));
                            else
                                push(String.valueOf(x1 - x2));
                            break;
                        case "*":
                            push(String.valueOf(x1 * x2));
                            break;
                        case "/":
                            if (x1 == 0)
                                push(String.valueOf("Syntax Error"));
                            else
                                push(String.valueOf(x2 / x1));
                            break;
                    }
                }else{
                    return "Syntax Error";
                }
            } else if (isOperand(s)) {
                tOS++;
                a[tOS] = s;
            }
        }

        String x = pop();
        return x;
    }


    private boolean isOperand(String s) {

        if(s != null && Character.isDigit(s.charAt(0))) {
            return true;
        }else{
            return false;
        }
    }


    private void push(String x) {

        if(tOS > MAX -1)
            System.out.println("OverFlow Stack!");
        else{
            tOS++;
            a[tOS] = x;
        }

    }

    public  String pop(){

        if(tOS != -1){
            x = String.valueOf(a[tOS]);
            tOS--;
            return x;
        }else {
            return "invalid";
        }
    }

}


