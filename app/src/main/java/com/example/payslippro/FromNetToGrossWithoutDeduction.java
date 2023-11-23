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

    @Override
    public int calculateOpv(int gross) {
        if (gross < 700000) {
            double opv = gross * 0.1;
            return (int) opv;
        } else if (gross >= 700000 & gross < 3500000) {
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
        } else if (gross >= 700000 & gross < 3500000) {
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
            double ipn = (gross - opv - vosms) * 0.1;
            return (int) ipn;
        } else if (gross >= 700000 & gross < 3500000) {
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