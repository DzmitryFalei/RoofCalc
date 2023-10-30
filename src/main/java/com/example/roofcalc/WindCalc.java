package com.example.roofcalc;

public class WindCalc {
    private double roughnessZo;
    private double heightZ;
    private double windSpeedVb;

    public WindCalc(double roughnessZo, double heightZ, double windSpeedVb) {
        this.roughnessZo = roughnessZo;
        this.heightZ = heightZ;
        this.windSpeedVb = windSpeedVb;
    }



    public double getPressureQpZ() {

        double coefficientKr = 0.19 * Math.pow((roughnessZo / 0.05), 0.07);
        double coefficientCrZ = coefficientKr * Math.log(heightZ / roughnessZo);
        double averageWindSpeedVmZ = coefficientCrZ * windSpeedVb;
        double turbulenceDeflection = coefficientKr * windSpeedVb;
        double turbulenceIntensityLvZ = turbulenceDeflection / averageWindSpeedVmZ;

        return (1 + 7 * turbulenceIntensityLvZ) * 0.5 * 1.25 * Math.pow(averageWindSpeedVmZ, 2) * 0.001;
    }
}
