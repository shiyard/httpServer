package de.bit.service;

public class CalculatePresenterImpl implements CalculatePresenter{


    @Override
    public String format(int n) {
        return "Sum: " + n;
    }
}
