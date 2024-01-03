package de.bit;

public class VectorCalculateService implements CalculateService{
    @Override
    public int calculate(int a, int b) {
        return  (int) Math.sqrt((double) a*a + (double) b*b);
    }
}
