package com.bigfoot.javacalc;

public interface DoubleCalcModel {

    /**
     * Reports the first input.
     *
     * @return this.firstInput
     */
    double firstInput();

    /**
     * Reports the second input.
     *
     * @return this.secondInput
     */
    double secondInput();

    /**
     * Reports the output.
     *
     * @return this.output
     */
    double output();

    void setFirstInput(double firstInput);

    void setSecondInput(double secondInput);

}