package com.example.roofcalc.model;

public class Roof {

    private double coefficientFCpe1;
    private double coefficientGCpe1;
    private double coefficientHCpe1;
    private double coefficientICpe1;

    public Roof(double coefficientFCpe1, double coefficientGCpe1, double coefficientHCpe1, double coefficientICpe1) {
        this.coefficientFCpe1 = coefficientFCpe1;
        this.coefficientGCpe1 = coefficientGCpe1;
        this.coefficientHCpe1 = coefficientHCpe1;
        this.coefficientICpe1 = coefficientICpe1;
    }

    public double getCoefficientFCpe1() {
        return coefficientFCpe1;
    }

    public void setCoefficientFCpe1(double coefficientFCpe1) {
        this.coefficientFCpe1 = coefficientFCpe1;
    }

    public double getCoefficientGCpe1() {
        return coefficientGCpe1;
    }

    public void setCoefficientGCpe1(double coefficientGCpe1) {
        this.coefficientGCpe1 = coefficientGCpe1;
    }

    public double getCoefficientHCpe1() {
        return coefficientHCpe1;
    }

    public void setCoefficientHCpe1(double coefficientHCpe1) {
        this.coefficientHCpe1 = coefficientHCpe1;
    }

    public double getCoefficientICpe1() {
        return coefficientICpe1;
    }

    public void setCoefficientICpe1(double coefficientICpe1) {
        this.coefficientICpe1 = coefficientICpe1;
    }
}
