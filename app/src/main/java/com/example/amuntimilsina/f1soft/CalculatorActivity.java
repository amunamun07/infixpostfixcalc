package com.example.amuntimilsina.f1soft;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amuntimilsina.f1soft.InfixToPostfix.InfixToPostfixMain;
import com.example.amuntimilsina.f1soft.InfixToPostfix.ValueStack;
import com.example.amuntimilsina.f1soft.SolvePostfix.StackJavaClass;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorActivity extends AppCompatActivity {


    EditText Input;
    TextView Display;
    ImageButton EqualsBtn;
    RecyclerView recycleView;
    RecyclerAdaptor adaptor;
    ArrayList<String> data = new ArrayList<>();
    static int[] a = new int[100];
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        Input = findViewById(R.id.Input);
        Display = findViewById(R.id.Display);
        recycleView = findViewById(R.id.Keys);
        EqualsBtn = findViewById(R.id.EqualsBtn);
        String[] keyitem = getResources().getStringArray(R.array.Keys);
        data.addAll(Arrays.asList(keyitem));

        Input.setInputType(InputType.TYPE_NULL);


        recycleView.setLayoutManager(new GridLayoutManager(CalculatorActivity.this,4));
        adaptor = new RecyclerAdaptor(data,CalculatorActivity.this,Input);
        recycleView.setAdapter(adaptor);

        EqualsBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Input.setText("");
                Display.setText("");
                ValueStack.ClearVStach();
                return true;
            }
        });


        EqualsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ValueStack.Vstackinit();
                StackJavaClass.Stackinitilization();

                String Expression = Input.getText().toString().trim();


                if (Expression.matches("")) {
                    x = 0;
                } else {
                    x = InfixToPostfixMain.ExpressionLinae(Expression);

                }

            if (x == 00000000)
                Display.setText("Syntax Error");
            else{
                Display.setText(String.valueOf(x));
            }
            }
});


            }
        }