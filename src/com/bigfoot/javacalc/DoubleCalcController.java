package com.bigfoot.javacalc;

/**
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

    void processSquareRootEvent();

    void processSquareEvent();

    void processPowerEvent();

    void processDivideEvent();

    void processMultiplyEvent();

    void processSubtractEvent();

    void processAddEvent();

    void processPosNegEvent();

    void processDigitEvent(double input);
}