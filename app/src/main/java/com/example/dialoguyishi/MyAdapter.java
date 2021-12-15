package com.example.dialoguyishi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {//problem
    private ArrayList<ModelClass> list;
    private Context context;


    public MyAdapter(ArrayList<ModelClass> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);// item_view ni topish uchun view kk
        MyViewHolder korish=new MyViewHolder(view);// MyViewHolder kanstructoriga murojat qiladi
                return korish;
    }

    public  void addItem(String ism, String izox){ // funksiya additem listga qo'shadi
        list.add(new ModelClass(R.drawable.chayka,"ism","izox"));
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name= list.get(position).getIsm();
        String disc=list.get(position).getMalumot();
        int image=list.get(position).getRasm();

        holder.malumot.setText(disc);
        holder.ism.setText(name);
        holder.rasm.setImageResource(image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }





    public class MyViewHolder extends RecyclerView.ViewHolder { //klass

        private TextView ism, malumot;
        private ImageView rasm;

        public MyViewHolder(@NonNull View itemView) {// kanstruktor
            super(itemView);
            ism=itemView.findViewById(R.id.name);
            malumot=itemView.findViewById(R.id.disc);
            rasm=itemView.findViewById(R.id.image);

        }
    }


}

