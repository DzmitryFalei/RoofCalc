package com.example.roofcalc;

public class FasteningPitch {

    private double peakValueOfVelocityPressureQpZ;
    private double tensileStrength;
    private double tearResistance;

    public FasteningPitch(double pressureQpZ, double tensileStrength, double tearResistance) {
        this.peakValueOfVelocityPressureQpZ = pressureQpZ;
        this.tensileStrength = tensileStrength;
        this.tearResistance = tearResistance;
    }

    public double getFasteningPitch(double pressureCoefficientFCpe) {

        double fasteningPitchForTearResistance = tearResistance / (0.5 * peakValueOfVelocityPressureQpZ * pressureCoefficientFCpe); // шаг крепления от раздира
        double fasteningPitchForTensileStrength = tensileStrength / (1.35 * peakValueOfVelocityPressureQpZ * pressureCoefficientFCpe); // шаг крепления от усилия

        return (int)Math.abs(Math.min(fasteningPitchForTearResistance, fasteningPitchForTensileStrength));
    }
}
