package com.bigfoot.javacalc;

/**
 * The interface for the calculator's Model class. It holds all the data for the
 * calculator. It's methods are basically just Getters and Setters with the
 * addition of a Clears method to reset the data.
 *
 * @author Justin Carruthers
 *
 */
public interface DoubleCalcModel {

    /**
     * Clears the model.
     */
    void clears();

    /**
     * Reports the first input.
     *
     * @return this.firstInput
     */
    double getFirstInput();

    /**
     * Reports the second input.
     *
     * @return this.secondInput
     */
    double getSecondInput();

    /**
     * Reports the output.
     *
     * @return this.output
     */
    double getOutput();

    /**
     * Reports the state of the model.
     *
     * @return the state of the model
     */
    String getState();

    /**
     * Reports the mode of the model.
     *
     * @return the mode of the model
     */
    String getMode();

    /**
     * Reports true if the first number is the number the calculator is working
     * on. False if it's the second number on.
     *
     * @return true if the first number is the number being worked on. False
     *         otherwise.
     */
    boolean getNumber();

    /**
     * Sets the pre-operation number.
     *
     * @param firstInput
     *            The pre-operation number clicked by user
     */
    void setFirstInput(double firstInput);

    /**
     * Sets the post-operation number.
     *
     * @param secondInput
     *            The post-operation number clicked by user
     */
    void setSecondInput(double secondInput);

    /**
     * Sets the output displayed by the calculator.
     *
     * @param output
     *            The output displayed by the calculator
     */
    void setOutput(double output);

    /**
     * Sets the state of the calculator.
     *
     * @param state
     *            The state of the calculator
     */
    void setCurrentState(String state);

    /**
     * Sets the mode of the calculator.
     *
     * @param mode
     *            The mode of the calculator
     */
    void setMode(String mode);

    /**
     * Sets which number the calculator is working on.
     *
     * @param firstNumber
     *            The number the calculator is working on
     */
    void firstOrSecond(boolean firstNumber);

}
