package com.example.roofcalc;

public class NumberOfAnchorsCalc {
    double pressureQpZ;
    double tearResistance;

    public NumberOfAnchorsCalc(double pressureQpZ, double tearResistance) {
        this.pressureQpZ = pressureQpZ;
        this.tearResistance = tearResistance;
    }

    public double getNumberOfAnchors(double coefficientFCpe) {
         return (int)Math.abs(pressureQpZ * coefficientFCpe / tearResistance * 1000);
    }

}
