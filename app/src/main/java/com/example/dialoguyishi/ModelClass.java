package com.example.dialoguyishi;

public class ModelClass {
   private int rasm;
    private String ism;
    private String malumot;

    public ModelClass(int rasm, String ism, String malumot) {
        this.rasm = rasm;
        this.ism = ism;
        this.malumot = malumot;
    }

    public int getRasm() {
        return rasm;
    }

    public String getIsm() {
        return ism;
    }

    public String getMalumot() {
        return malumot;
    }
}
