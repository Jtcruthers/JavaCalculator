package com.bigfoot.javacalc;

/**
 *
 * @author Justin Carruthers and Ryan Tomlinson
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
        double output = this.model.getOutput();
        /*
         * Update view to reflect changes in model
         */
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
        this.updateViewToMatchModel();
    }

    @Override
    public void processEnterEvent() {
        double firstInput = this.model.getFirstInput();
        double secondInput = this.model.getSecondInput();

        if (!this.model.getFirstOrSecond()) {
            switch (this.model.getMode()) {
                case "ADD":
                    this.model.setOutput(firstInput + secondInput);
                    break;
                case "SUB":
                    this.model.setOutput(firstInput - secondInput);
                    break;
                case "DIV":
                    this.model.setOutput(firstInput / secondInput);
                    break;
                case "MULT":
                    this.model.setOutput(firstInput * secondInput);
                    break;
                case "POWER":
                    this.model.setOutput(Math.pow(firstInput, secondInput));
                    break;
                default:
                    break;
            }
        } else {
            switch (this.model.getMode()) {
                case "SQUARE":
                    this.model.setOutput(firstInput * firstInput);
                    break;
                case "ROOT":
                    this.model.setOutput(Math.sqrt(firstInput));
                    break;
                default:

            }
        }
        this.updateViewToMatchModel();

    }

    @Override
    public void processAddEvent() {
        this.model.setMode("ADD");
        this.model.firstOrSecond(false);
    }

    @Override
    public void processSubtractEvent() {
        this.model.setMode("SUB");
        this.model.firstOrSecond(false);
    }

    @Override
    public void processMultiplyEvent() {
        this.model.setMode("MULT");
        this.model.firstOrSecond(false);
    }

    @Override
    public void processDivideEvent() {
        this.model.setMode("DIV");
        this.model.firstOrSecond(false);
    }

    @Override
    public void processPowerEvent() {
        this.model.setMode("POWER");
        this.model.firstOrSecond(false);
    }

    @Override
    public void processSquareRootEvent() {
        this.model.setMode("ROOT");
    }

    @Override
    public void processSquareEvent() {
        this.model.setMode("SQUARE");
    }

    @Override
    public void processPosNegEvent() {
        if (this.model.getFirstOrSecond()) {
            this.model.setFirstInput(this.model.getFirstInput() * -1);
            this.model.setOutput(this.model.getFirstInput());
        } else {
            this.model.setSecondInput(this.model.getSecondInput() * -1);
            this.model.setOutput(this.model.getSecondInput());
        }
        this.updateViewToMatchModel();
    }

    @Override
    public void processDigitEvent(double input) {
        double first = this.model.getFirstInput();
        double second = this.model.getSecondInput();

        if (this.model.getFirstOrSecond()) {
            first = first * 10 + input;
            this.model.setFirstInput(first);
            this.model.setOutput(first);
        } else {
            second = second * 10 + input;
            this.model.setSecondInput(second);
            this.model.setOutput(second);
        }
        this.updateViewToMatchModel();
    }

    @Override
    public void processClearEvent() {
        /*
         * Clear them in response to event
         */
        this.model.clears();
        /*
         * Update view to reflect changes in model
         */
        this.updateViewToMatchModel();
    }
}
