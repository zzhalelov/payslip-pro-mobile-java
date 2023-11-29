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
        if (gross < 54900) {
            double ipn = 0;
            return (int) ipn;
        } else if (gross < 86250) {
            double opv = gross * 0.1;
            double vosms = gross * 0.02;
            double ipn = ((gross - opv - vosms - 48300) * 0.1) * 0.1;
            return (int) ipn;
        } else if (gross < 700000) {
            double opv = gross * 0.1;
            double vosms = gross * 0.02;
            double ipn = (gross - opv - vosms - 48300) * 0.1;
            return (int) ipn;
        } else if (gross < 3500000) {
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