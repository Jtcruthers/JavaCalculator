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
    private double input1 = 0, input2 = 0, output = 0;

    /**
     *
     */
    public DoubleCalcModel1() {
        this.input1 = 0;
        this.input2 = 0;
        this.output = 0;

    }

    @Override
    public Double input1() {

        return this.input1;
    }

    @Override
    public Double input2() {

        return this.input2();
    }

    @Override
    public Double output() {

        return this.output();
    }
}
