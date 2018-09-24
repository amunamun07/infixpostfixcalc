package com.example.amuntimilsina.f1soft;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.ViewHolder> {

    ArrayList<String> data;
    Context context;
    EditText Input;

    public RecyclerAdaptor(ArrayList<String> data, Context context, EditText Input) {
        this.data = data;
        this.context = context;
        this.Input = Input;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridcell,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
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
                    Log.i("hello:",x);
                }
            });
        }

    }

}
