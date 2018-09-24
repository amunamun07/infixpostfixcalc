package com.example.amuntimilsina.f1soft.InfixToPostfix;


import com.example.amuntimilsina.f1soft.SolvePostfix.StackJavaClass;

public class ConversionWork {
    static int MAX = 100;
    static String[] converted = new String[MAX];
    static int FinalOutput;



    public static int convertTOpostFix(String[] expression) {


        ValueStack.Vstackinit();
        for (int i = 0; i < expression.length; i++) {
                    ValueStack.PostfixConversion(expression[i]);
        }
        ValueStack.PopTheRemainingStack();


        StackJavaClass.Stackinitilization();
        for (int j = 0; j < expression.length; j++) {

            converted[j] = ValueStack.getPostfixString(j);

            System.out.println("ff2:"+converted[j]);

            if (converted[j] != "invalid") {
                System.out.println("ff:" + converted[j]);
                  StackJavaClass.push(converted[j]);
            }else {
                 FinalOutput = 000000;
            }

        }
        FinalOutput = StackJavaClass.FinalOutput();
        return FinalOutput;
    }


    private static boolean isOperand(String exp){

        if(!exp.equals(null) && !exp.equals("") && Character.isDigit(exp.charAt(0))) {
            return true;
        }else{
            return false;
        }

    }
}
