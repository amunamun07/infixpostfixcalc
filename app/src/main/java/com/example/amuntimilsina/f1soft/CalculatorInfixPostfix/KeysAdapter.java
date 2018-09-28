package com.example.amuntimilsina.f1soft.CalculatorInfixPostfix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.amuntimilsina.f1soft.R;

import java.util.ArrayList;

public class KeysAdapter extends RecyclerView.Adapter<KeysAdapter.ViewHolder> {

    ArrayList<String> data;
    Context context;
    EditText Input;


    public KeysAdapter(ArrayList<String> data, Context context, EditText Input) {
        this.data = data;
        this.context = context;
        this.Input = Input;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView myTextView;
        RelativeLayout Key_btn;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.key_text);
            Key_btn = itemView.findViewById(R.id.Key_btn);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String x = myTextView.getText().toString();

                }
            });
        }

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridcell,parent,false);
        KeysAdapter.ViewHolder viewHolder = new KeysAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.myTextView.setText(data.get(position));

        holder.Key_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Input.append(data.get(position));

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
