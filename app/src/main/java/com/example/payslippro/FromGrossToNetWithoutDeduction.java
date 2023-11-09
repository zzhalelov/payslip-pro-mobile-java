package com.example.payslippro;

public class FromGrossToNetWithoutDeduction extends FromGrossToNet {
    @Override
    public int calculateFromGrossToNet(int gross) {
        super.calculateFromGrossToNet(gross);

        return gross;
    }
}