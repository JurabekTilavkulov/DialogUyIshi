package com.example.dialoguyishi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogFragment extends AppCompatDialogFragment {
   EditText name, discription;
  Addmember listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        builder.setTitle("Add your section"); // title nome beramiz

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.custom_dialog,null);

        name=view.findViewById(R.id.et1);
        discription=view.findViewById(R.id.et2);// tugri

        builder.setView(view);// custom_layoutda yasagan ko'rinishni o'ziga oladi dialog

        //Add tugmasi yaratilib uni bosilishi ko'rib chiqiladi
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(inflater.getContext(),name.getText().toString()+"",Toast.LENGTH_LONG).show();
                listener.addText(name.getText().toString()+"",discription.getText().toString()+""); // nul information?
            }
        });


        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {  ///on creatde dan oldin ishlashni beradi

        try {
            listener= (Addmember) context ;
        }
        catch (Exception e){ //xatolik
            throw new ClassCastException("----"+context.toString()+"must implement ExampleDialogListener");
        }
        super.onAttach(context);
    }

    interface Addmember{  // boshlanishi
        void addText(String name, String disc);
    }
}
