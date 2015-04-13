package com.bigfoot.javacalc;

/**
 *
 * @author Ryan Tomlinson and Justin Carruthers
 *
 */
public final class DoubleCalcModel1 implements DoubleCalcModel {

    /**
     *
     */
    private double firstInput, secondInput, output;

    /**
     * An enumeration containing possible operation modes.
     *
     */
    public static enum Mode {
        ADD, SUB, DIV, MULT, SQUARE, POWER, ROOT, NULL
    }

    /**
     *
     */
    private boolean firstOrSecond, hasBeenEntered;

    /**
     * What operation the calculator is going to perform.
     */
    private Mode currentMode;

    /**
     * No argument constructor for the model. Makes sure both inputs and the
     * output are set to 0, and the state and mode are neutral.
     *
     */
    public DoubleCalcModel1() {
        this.clears();
    }

    @Override
    public void clears() {
        this.firstInput = 0;
        this.secondInput = 0;
        this.output = 0;
        this.currentMode = Mode.NULL;
        this.firstOrSecond = true;
        this.hasBeenEntered = false;
    }

    @Override
    public double getFirstInput() {
        return this.firstInput;
    }

    @Override
    public double getSecondInput() {
        return this.secondInput;
    }

    @Override
    public double getOutput() {
        return this.output;
    }

    @Override
    public String getMode() {
        return this.currentMode.toString();
    }

    @Override
    public boolean getFirstOrSecond() {
        return this.firstOrSecond;
    }

    @Override
    public boolean getHasBeenEntered() {
        return this.hasBeenEntered;
    }

    @Override
    public void setFirstInput(double firstInput) {
        this.firstInput = firstInput;
    }

    @Override
    public void setSecondInput(double secondInput) {
        this.secondInput = secondInput;
    }

    @Override
    public void setOutput(double output) {
        this.output = output;
    }

    @Override
    public void setMode(String mode) {
        Mode newMode = Mode.valueOf(mode);
        this.currentMode = newMode;
    }

    @Override
    public void firstOrSecond(boolean trueForFirst) {
        this.firstOrSecond = trueForFirst;
    }

    @Override
    public void setHasBeenEntered(boolean hBE) {
        this.hasBeenEntered = hBE;
    }
}
