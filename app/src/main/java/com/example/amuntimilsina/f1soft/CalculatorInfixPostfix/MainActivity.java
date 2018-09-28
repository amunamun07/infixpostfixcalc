package com.example.amuntimilsina.f1soft.CalculatorInfixPostfix;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.amuntimilsina.f1soft.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText Input;
    TextView Display;
    ImageButton EqualsBtn;
    RecyclerView recycleView;
    ArrayList<String> data = new ArrayList<>();
    List<String> PostFixExp = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Input = findViewById(R.id.Input);
        Display = findViewById(R.id.Display);
        recycleView = findViewById(R.id.Keys);
        EqualsBtn = findViewById(R.id.EqualsBtn);
        String[] keyitem = getResources().getStringArray(R.array.Keys);
        data.addAll(Arrays.asList(keyitem));

        Input.setInputType(InputType.TYPE_NULL);

        recycleView.setLayoutManager(new GridLayoutManager(MainActivity.this,4));
        KeysAdapter adaptor = new KeysAdapter(data,MainActivity.this,Input);
        recycleView.setAdapter(adaptor);


        EqualsBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ConvertToPostfix c = new ConvertToPostfix();
                c.ClearVStach();
                PostFixExp.clear();
                Input.setText("");
                Display.setText("");
                return true;
            }
        });

        EqualsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostFixExp.clear();
                ConvertToPostfix c = new ConvertToPostfix();
                c.ClearVStach();
                c.Vstackinit();
                String InfixExpression = Input.getText().toString().trim();

                List<String> PostFixExpression = c.PostfixExpression(InfixExpression);

                if(PostFixExpression.get(0).equals("Syntax Error")){
                    String FinalOutPut = PostFixExpression.get(0);
                    Display.setText(FinalOutPut);

                }else{
                    int j = 0;
                    for (int i=0;i<PostFixExpression.size() && j<PostFixExpression.size();i++){
                        if(PostFixExpression.get(i) != "invalid"){
                            PostFixExp.add(j,PostFixExpression.get(i));
                            j++;
                        }
                    }

                    PostfixEvaluation p = new PostfixEvaluation();
                    String FinalOutPut = p.Evaluate(PostFixExp);
                    Display.setText(FinalOutPut);
                }

            }
        });


    }
}
