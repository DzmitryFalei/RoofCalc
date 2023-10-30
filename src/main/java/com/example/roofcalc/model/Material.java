package com.example.roofcalc.model;

public class Material {

    private String name;
    private  int tensileStrength;
    private int tearResistance;

    public Material(String name, int tensileStrength, int tearResistance) {
        this.name = name;
        this.tensileStrength = tensileStrength;
        this.tearResistance = tearResistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTensileStrength() {
        return tensileStrength;
    }

    public void setTensileStrength(int tensileStrength) {
        this.tensileStrength = tensileStrength;
    }

    public int getTearResistance() {
        return tearResistance;
    }

    public void setTearResistance(int tearResistance) {
        this.tearResistance = tearResistance;
    }
}
