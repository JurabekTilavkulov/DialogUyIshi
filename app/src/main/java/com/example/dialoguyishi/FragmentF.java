package com.example.dialoguyishi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentF extends Fragment implements DialogFragment.Addmember { //problem
    private ArrayList<ModelClass>list;
    private MyAdapter adapter;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmentf_layout,container,false);// fragment layout ni izlab topadi
        recyclerView=view.findViewById(R.id.res);// recycleviewni topamiz
        loaddata();
        fab=view.findViewById(R.id.fab);
        adapter=new MyAdapter(list,inflater.getContext());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(inflater.getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(inflater.getContext(),"fab bosildi",Toast.LENGTH_LONG).show();

                DialogFragment dialogFragment=new DialogFragment(); // dialogFragment clasidan obect olmoqda
                dialogFragment.show(getParentFragmentManager(),"fragment");

            }
        });


        return view;
    }
    private void  loaddata(){
        list=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new ModelClass(R.drawable.baqa2,"nomi","Izox"));
        }

    }

    @Override
    public void addText(String name, String disc) {
        adapter.addItem(name,disc);
    }
}
