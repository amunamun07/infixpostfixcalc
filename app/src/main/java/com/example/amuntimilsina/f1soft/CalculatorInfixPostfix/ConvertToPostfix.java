package com.example.amuntimilsina.f1soft.CalculatorInfixPostfix;

import java.util.ArrayList;
import java.util.List;

class ConvertToPostfix {

    int j=0;
    String t;
    int MAX =100;
    int topOfStack;
    private String[] a = new String[MAX];
    List<String> SplittedExpressionlist = new ArrayList<String>();
    List<String> PostfixExpression = new ArrayList<String>();
    List<String> Post = new ArrayList<String>();

    public void Vstackinit(){
        topOfStack = -1;
    }


    public List<String> PostfixExpression(String infixExpression) {

        System.out.println("aaaaaa:"+infixExpression);

        SplittedExpressionlist = SplitExpression(infixExpression);
        PostfixExpression = getPostfixExpression(SplittedExpressionlist);
        return PostfixExpression;
    }

    private List<String> getPostfixExpression(List<String> exp) {

        for(String lol : exp){

            if (lol.equals("(")) {
                Push(lol);

            } else if (isOperand(lol)) {
                Post.add(j,lol);
                j++;

            } else if (isOperator(lol)) {

                t = pop();
                while (isOperator(t) && (precedence(t) >= precedence(lol))) {
                    Post.add(j,t);
                    j++;
                    t = pop();
                }
                Push(t);
                Push(lol);

            } else if (lol.equals(")")) {
                t = pop();
                if(t.equals("invalid")){
                    List<String> l = new ArrayList<String>();
                    l.add(0,"Syntax Error");
                    return l;
                }

                while (!t.equals("(")) {
                    Post.add(j,t);
                    j++;
                    t = pop();
                }

            }else {
                Push("invalid");
            }

        }
        PopTheRemainingStack();

        return Post;
    }


    private List<String> SplitExpression(String e) {

        String[] exp = new String[MAX];
        String[] exp2 = new String[MAX];


        for(int i=0;i<e.length();i++){
            exp[i] = String.valueOf(e.charAt(i));
        }

        int i=0;
        int l=0;
        do{

            if(isOperand(exp[i]) && isOperand(exp[i+1])) {
                int j = i+1;
                int k=i;
                while(!isOperator2(exp[j]) && exp[j] != null){
                    exp[k] = exp[k]+exp[j];
                    j++;
                    i++;
                }
                exp2[l] = exp[k];
            }else {

                exp2[l] = exp[i];
            }
            i++;
            l++;
        }while(exp2[l-1]!=null);

        List<String> list = new ArrayList<String>();
        for(String s : exp2) {
            if(s != null && s.length() > 0) {
                list.add(s);
            }
        }

        return list;
    }

    private boolean isOperator2(String s) {
        if(s != null && (s.equals("^") || s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")")))
            return true;
        else
            return false;
    }

    private boolean isOperator(String s) {
        if(s!= null && (s.equals("^") || s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")))
            return true;
        else
            return false;
    }

    private boolean isOperand(String s) {

        if(s != null && Character.isDigit(s.charAt(0))) {
            return true;
        }else{
            return false;
        }
    }
    private String pop() {

        if(topOfStack != -1){
            String x = a[topOfStack];
            topOfStack--;
            return x;
        }
        else {
            return "invalid";
        }
    }

    private void Push(String x) {

        if(topOfStack > MAX -1)
            System.out.println("OverFlow Stack!");
        else{
            topOfStack++;
            a[topOfStack] = x;
        }

    }

    private int precedence(String exp) {

        if(exp.equals("^"))
            return (3);
        else if(exp.equals("*") || exp.equals("/"))
            return (2);
        else if(exp.equals("+") || exp.equals("-"))
            return (1);
        else
            return (0);

    }

    public void PopTheRemainingStack() {
        while(topOfStack > 0){
            Post.add(j,pop());
            j++;
        }
        Post.add(j,"\0");
    }

    public void ClearVStach(){

        while(topOfStack != -1){
            pop();
        }
        Post.clear();
        PostfixExpression.clear();
        SplittedExpressionlist.clear();
        j=0;
    }

}
