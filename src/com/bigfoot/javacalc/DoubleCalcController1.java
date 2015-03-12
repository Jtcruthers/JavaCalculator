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
        double input1 = this.model.input1();
        double input2 = this.model.input2();
        double output = this.model.output();
        /*
         * Update view to reflect changes in model
         */
        this.view.updateInput1(input1);
        this.view.updateInput2(input2);
        this.view.updateOutput(output);
    }

    /**
     *
     * @param model
     * @param view
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
        double input1 = this.model.input1();
        double input2 = this.model.input2();
        double output = this.model.output();
        /*
         * Clear them in response to event
         */
        input1 = 0;
        input2 = 0;
        output = 0;
        /*
         * Update view to reflect changes in model
         */
        this.updateViewToMatchModel();
    }

    @Override
    public void processEnterEvent() {

        // TODO - How are we supposed to implement the other methods?
    }
}
