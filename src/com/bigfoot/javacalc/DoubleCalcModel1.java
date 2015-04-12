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
     * An enumeration containing possible buttons pressed.
     *
     */
    private static enum State {
        SAW_CLEAR,
        SAW_ENTER,
        SAW_OTHER_OP,
        SAW_DIGIT,
        SAW_ADD,
        SAW_SUB,
        SAW_POWER,
        SAW_ROOT,
        SAW_SQUARE,
        SAW_MULTIPLY,
        SAW_DIVIDE,
        SAW_POSNEG,
        SAW_DEC
    }

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
    private boolean firstOrSecond;

    /**
     * What button was just pressed by the calculator.
     *
     */
    private State currentState;

    /**
     * What operation the calculator is going to preform.
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
        this.currentState = State.SAW_CLEAR;
        this.currentMode = Mode.NULL;
        this.firstOrSecond = true;
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
    public String getState() {
        return this.currentState.toString();
    }

    @Override
    public String getMode() {
        return this.currentMode.toString();
    }

    @Override
    public boolean getNumber() {
        return this.firstOrSecond;
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
    public void setCurrentState(String state) {
        State newState = State.valueOf(state);
        this.currentState = newState;
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
}
