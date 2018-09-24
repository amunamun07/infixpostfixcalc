package com.example.amuntimilsina.f1soft.InfixToPostfix;


import java.util.ArrayList;
import java.util.List;

public class InfixToPostfixMain {
    final static int SIZE = 100;
    static String[] exp1 = new String[SIZE];
    static String[] exp2 = new String[SIZE];
    static String[] a = new String[SIZE];
    static List<String> values = new ArrayList<String>();


    public static int ExpressionLinae(String infix) {

        exp1 = infix.split("(?<=[-+*/()^])|(?=[-+*/()^])");

        if(isOperator(infix.charAt(0))){
            for(int i=0;i<exp1.length-2;i++){
                exp2[i] = exp1[i+1];
                System.out.println("aa:"+exp2[i]);
            }

             int FinalOutput = ConversionWork.convertTOpostFix(exp2);
            return 0;
        }else {
             int FinalOutput = ConversionWork.convertTOpostFix(exp1);
            return 0;
        }

    }


    private static boolean isOperator(char exp){

        if(exp != ' ' &&(exp == '(' || exp == ')'))
            return true;
        else
            return false;
    }

    private static boolean isOperator(String exp){

        if(exp != " " &&(exp == "(" || exp == ")"))
            return true;
        else
            return false;
    }
}
