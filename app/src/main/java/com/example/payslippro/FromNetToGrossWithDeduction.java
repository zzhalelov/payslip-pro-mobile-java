package com.example.payslippro;

public class FromNetToGrossWithDeduction extends FromNetToGross {
    @Override
    public int calculateFromNetToGross(int net) {
        if (net <= 48300) {
            double gross = net / 0.88;
            return (int) gross;
        } else if (net > 48300 & net <= 75624) {
            double gross = (net - 483) / 0.8712;
            return (int) gross;
        } else if (net > 75624 & net <= 559230) {
            double gross = (net - 4830) / 0.792;
            return (int) gross;
        } else if ((net > 559230 & net <= 2827230)) {
            double gross = (net + 7770) / 0.81;
            return (int) gross;
        } else if (net > 2827230) {
            double gross = (net + 322770) / 0.9;
            return (int) gross;
        }
        return 0;
    }
}