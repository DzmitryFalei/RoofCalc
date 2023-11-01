package com.example.roofcalc;

public class FasteningPitchCalc {

    private double peakValueOfVelocityPressureQpZ;
    private double tensileStrength;
    private double tearResistance;

    public FasteningPitchCalc(double pressureQpZ, double tensileStrength, double tearResistance) {
        this.peakValueOfVelocityPressureQpZ = pressureQpZ;
        this.tensileStrength = tensileStrength;
        this.tearResistance = tearResistance;
    }

    public int getFasteningPitch(double pressureCoefficientFCpe) {

        double fasteningPitchForTearResistance = tearResistance / (0.5 * peakValueOfVelocityPressureQpZ * pressureCoefficientFCpe); // шаг крепления от раздира
        double fasteningPitchForTensileStrength = tensileStrength / (1.35 * peakValueOfVelocityPressureQpZ * pressureCoefficientFCpe); // шаг крепления от усилия

        return (int)Math.abs(Math.min(fasteningPitchForTearResistance, fasteningPitchForTensileStrength));
    }
}
