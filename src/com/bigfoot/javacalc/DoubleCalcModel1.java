package com.bigfoot.javacalc;

/**
 *
 * @author Ryan
 *
 */
public final class DoubleCalcModel1 implements DoubleCalcModel {

    /**
     *
     */
    private double firstInput, secondInput, output;

    /**
     *
     */
    public DoubleCalcModel1() {
        this.firstInput = 0;
        this.secondInput = 0;
        this.output = 0;

    }

    //Returns firstInput
    @Override
    public double firstInput() {
        return this.firstInput;
    }

    //Returns secondInput
    @Override
    public double secondInput() {
        return this.secondInput();
    }

    //Returns output
    @Override
    public double output() {
        return this.output();
    }

    //Sets firstInput
    @Override
    public void setFirstInput(double firstInput) {
        this.firstInput = firstInput;
    }

    //Sets secondInput
    @Override
    public void setSecondInput(double secondInput) {
        this.secondInput = secondInput;
    }
}
