package de.bit.service;

public class LinearCalculateService implements CalculateService{
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
