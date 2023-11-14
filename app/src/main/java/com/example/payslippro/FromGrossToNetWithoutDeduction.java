package com.example.payslippro;

public class FromGrossToNetWithoutDeduction extends FromGrossToNet {
    @Override
    public int calculateFromGrossToNet(int gross) {
        if (gross < 700000) {
            double opv = gross * 0.1;
            double vosms = gross * 0.02;
            double ipn = (gross - opv - vosms) * 0.1;
            double net = gross - opv - vosms - ipn;
            return (int) net;
        } else if (gross > 700000 & gross < 3500000) {
            double opv = gross * 0.1;
            double vosms = 14000;
            double ipn = (gross - opv - vosms) * 0.1;
            double net = gross - opv - vosms - ipn;
            return (int) net;
        } else if (gross > 3500000) {
            double opv = 350000;
            double vosms = 14000;
            double ipn = (gross - opv - vosms) * 0.1;
            double net = gross - opv - vosms - ipn;
            return (int) net;
        }
        return 0;
    }
}