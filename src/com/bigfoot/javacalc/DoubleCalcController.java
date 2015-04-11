package com.bigfoot.javacalc;

/**
 * The interface for the calculator's Controller class. It controls the
 * calculator's View and Model. It updates the view to match the model, keeps
 * the model's information up to date, and determines how to process the data.
 *
 * @author Ryan Tomlinson and Justin Carruthers
 *
 */
public interface DoubleCalcController {

    /**
     * Processes what to do when user clicks Clear.
     */
    void processClearEvent();

    /**
     * Processes what to do when user clicks Enter.
     */
    void processEnterEvent();

    /**
     * Processes what to do when user clicks Square Root.
     */
    void processSquareRootEvent();

    /**
     * Processes what to do when user clicks Square.
     */
    void processSquareEvent();

    /**
     * Processes what to do when user clicks Power.
     */
    void processPowerEvent();

    /**
     * Processes what to do when user clicks Divide.
     */
    void processDivideEvent();

    /**
     * Processes what to do when user clicks Multiply.
     */
    void processMultiplyEvent();

    /**
     * Processes what to do when user clicks Subtract.
     */
    void processSubtractEvent();

    /**
     * Processes what to do when user clicks Add.
     */
    void processAddEvent();

    /**
     * Processes what to do when user clicks +/-.
     */
    void processPosNegEvent();

    /**
     *
     * @param input
     *            The digit hit by the user.
     */
    void processDigitEvent(double input);
}
