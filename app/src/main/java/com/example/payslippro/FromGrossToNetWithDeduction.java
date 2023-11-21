package com.example.payslippro;

public class FromGrossToNetWithDeduction extends FromGrossToNet {
    @Override
    public int calculateFromGrossToNet(int gross) {
        if (gross < 700000) {
            double opv = gross * 0.1;
            double vosms = gross * 0.02;
            double ipn = (gross - opv - vosms - 48300) * 0.1;
            double net = gross - opv - vosms - ipn;
            return (int) net;
        } else if (gross > 700000 & gross < 3500000) {
            double opv = gross * 0.1;
            double vosms = 14000;
            double ipn = (gross - opv - vosms - 48300) * 0.1;
            double net = gross - opv - vosms - ipn;
            return (int) net;
        } else if (gross > 3500000) {
            double opv = 350000;
            double vosms = 14000;
            double ipn = (gross - opv - vosms - 48300) * 0.1;
            double net = gross - opv - vosms - ipn;
            return (int) net;
        }
        return 0;
    }

    @Override
    public int calculateOpv(int gross) {
        if (gross < 700000) {
            double opv = gross * 0.1;
            return (int) opv;
        } else if (gross > 700000 & gross < 3500000) {
            double opv = gross * 0.1;
            return (int) opv;
        } else if (gross > 3500000) {
            double opv = 350000;
            return (int) opv;
        }
        return 0;
    }

    @Override
    public int calculateVosms(int gross) {
        if (gross < 700000) {
            double vosms = gross * 0.02;
            return (int) vosms;
        } else if (gross > 700000 & gross < 3500000) {
            double vosms = 14000;
            return (int) vosms;
        } else if (gross > 3500000) {
            double vosms = 14000;
            return (int) vosms;
        }
        return 0;
    }

    @Override
    public int calculateIpn(int gross) {
        if (gross < 700000) {
            double opv = gross * 0.1;
            double vosms = gross * 0.02;
            double ipn = (gross - opv - vosms - 48300) * 0.1;
            return (int) ipn;
        } else if (gross > 700000 & gross < 3500000) {
            double opv = gross * 0.1;
            double vosms = 14000;
            double ipn = (gross - opv - vosms - 48300) * 0.1;
            return (int) ipn;
        } else if (gross > 3500000) {
            double opv = 350000;
            double vosms = 14000;
            double ipn = (gross - opv - vosms - 48300) * 0.1;
            return (int) ipn;
        }
        return 0;
    }
}