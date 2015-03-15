package com.bigfoot.javacalc;

/**
 *
 * @author Ryan Tomlinson and Justin Carruthers
 *
 */
public final class DoubleCalcController1 implements DoubleCalcController {

    /**
     *
     */
    private final DoubleCalcModel model;

    /**
     *
     */
    private final DoubleCalcView view;

    /**
     *
     */
    private void updateViewToMatchModel() {
        /*
         * Get model info
         */
        double firstInput = this.model.firstInput();
        double secondInput = this.model.secondInput();
        double output = this.model.output();
        /*
         * Update view to reflect changes in model
         */
        this.view.updateInput1(firstInput);
        this.view.updateInput2(secondInput);
        this.view.updateOutput(output);
    }

    /**
     *
     * @param model
     *            The model that keeps the data
     * @param view
     *            The view that controls the GUI
     */
    public DoubleCalcController1(DoubleCalcModel model, DoubleCalcView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void processClearEvent() {
        /*
         * Retrieve values
         */
        double firstInput = this.model.firstInput();
        double secondInput = this.model.secondInput();
        double output = this.model.output();
        /*
         * Clear them in response to event
         */
        firstInput = 0;
        secondInput = 0;
        output = 0;
        /*
         * Update view to reflect changes in model
         */
        this.updateViewToMatchModel();
    }

    @Override
    public void processEnterEvent() {

        // TODO: fill in body

    }

    @Override
    public void processAddEvent() {

        // TODO: fill in body

    }

    @Override
    public void processSubtractEvent() {

        // TODO: fill in body

    }

    @Override
    public void processMultiplyEvent() {

        // TODO: fill in body

    }

    @Override
    public void processDivideEvent() {

        // TODO: fill in body

    }

    @Override
    public void processPowerEvent() {

        // TODO: fill in body

    }

    @Override
    public void processSquareRootEvent() {

        // TODO: fill in body

    }

    @Override
    public void processSquareEvent() {

        // TODO: fill in body

    }

    @Override
    public void processPosNegEvent() {

        // TODO: fill in body

    }

    /**
     * THIS ISNT RIGHT. We need to figure out how to determine which input to
     * alter. However, I do think this is how we need to do it. Because they
     * enter the digit in the biggest column first and we want to see each digit
     * they hit in real time, this is the way to go. If the last button they hit
     * was a digit, then we need to add whatever button to the end.
     *
     * @param input
     */
    @Override
    public void processAddDigit(double input) {

        double tmp = this.model.firstInput();
        tmp *= 10;
        tmp += input;
        this.model.setFirstInput(tmp);
        this.updateViewToMatchModel();

    }

    @Override
    public void processDigitEvent(double input) {

        // if (this.view.currentState == this.view.State.)
    }
}
