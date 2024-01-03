package de.bit.service;

public class VectorCalculateService implements CalculateService{
    @Override
    public int calculate(int a, int b) {
        return  (int) Math.sqrt((double) a*a + (double) b*b);
    }
}
