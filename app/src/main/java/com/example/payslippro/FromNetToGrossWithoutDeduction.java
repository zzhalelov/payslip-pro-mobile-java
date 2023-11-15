package com.example.payslippro;

public class FromNetToGrossWithoutDeduction extends FromNetToGross {
    @Override
    public int calculateFromNetToGross(int net) {
        if (net <= 75141) {
            double gross = net / 0.8712;
            return (int) gross;
        } else if (net > 75141 & net <= 554400) {
            double gross = net / 0.792;
            return (int) gross;
        } else if (net > 554400 & net <= 2822400) {
            double gross = (net + 12600) / 0.81;
            return (int) gross;
        } else if (net > 2822400) {
            double gross = (net + 327600) / 0.9;
            return (int) gross;
        }
        return 0;
    }
}