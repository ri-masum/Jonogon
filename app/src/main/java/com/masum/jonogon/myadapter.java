package com.masum.jonogon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.auth.data.model.User;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{


    Context context;
    ArrayList<model> userArrayList;

    public myadapter(Context context, ArrayList<model> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v= LayoutInflater.from(context).inflate(R.layout.singlerowdesign,parent,false);

        return new myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        model model=userArrayList.get(position);
        holder.name.setText(model.getPREName());
        holder.email.setText(model.getFatherName());
        holder.number.setText(model.getNumber());
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{

       ImageView imageView;
        TextView name,email,number;




        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            number=itemView.findViewById(R.id.number);
            imageView=itemView.findViewById(R.id.img1);

        }
    }

}
