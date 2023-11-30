package com.myApp.payslippro;

public class FromGrossToNetWithoutDeduction extends FromGrossToNet {
    @Override
    public int calculateFromGrossToNet(int gross) {
        if (gross < 86250) {
            double opv = gross * 0.1;
            double vosms = gross * 0.02;
            double ipn = ((gross - opv - vosms) * 0.1) * 0.1;
            double net = gross - opv - vosms - ipn;
            return (int) net;
        } else if (gross < 700000) {
            double opv = gross * 0.1;
            double vosms = gross * 0.02;
            double ipn = (gross - opv - vosms) * 0.1;
            double net = gross - opv - vosms - ipn;
            return (int) net;
        } else if (gross < 3500000) {
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

    @Override
    public int calculateOpv(int gross) {
        if (gross < 3500000) {
            double opv = gross * 0.1;
            return (int) opv;
        } else {
            double opv = 350000;
            return (int) opv;
        }
    }

    @Override
    public int calculateVosms(int gross) {
        if (gross < 700000) {
            double vosms = gross * 0.02;
            return (int) vosms;
        } else {
            double vosms = 14000;
            return (int) vosms;
        }
    }

    @Override
    public int calculateIpn(int gross) {
        if (gross < 86250) {
            double opv = gross * 0.1;
            double vosms = gross * 0.02;
            double ipn = ((gross - opv - vosms) * 0.1) * 0.1;
            return (int) ipn;
        } else if (gross < 700000) {
            double opv = gross * 0.1;
            double vosms = gross * 0.02;
            double ipn = (gross - opv - vosms) * 0.1;
            return (int) ipn;
        } else if (gross < 3500000) {
            double opv = gross * 0.1;
            double vosms = 14000;
            double ipn = (gross - opv - vosms) * 0.1;
            return (int) ipn;
        } else if (gross > 3500000) {
            double opv = 350000;
            double vosms = 14000;
            double ipn = (gross - opv - vosms) * 0.1;
            return (int) ipn;
        }
        return 0;
    }
}