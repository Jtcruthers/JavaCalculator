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
     *
     */
    void processClearEvent();

    /**
     *
     */
    void processEnterEvent();

    /**
     *
     */
    void processSquareRootEvent();

    /**
     *
     */
    void processSquareEvent();

    /**
     *
     */
    void processPowerEvent();

    /**
     *
     */
    void processDivideEvent();

    /**
     *
     */
    void processMultiplyEvent();

    /**
     *
     */
    void processSubtractEvent();

    /**
     *
     */
    void processAddEvent();

    /**
     *
     */
    void processPosNegEvent();

    /**
     *
     * @param input
     *            The digit hit by the user.
     */
    void processDigitEvent(double input);
}
