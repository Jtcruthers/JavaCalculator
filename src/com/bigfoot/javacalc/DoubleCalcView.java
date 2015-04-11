package com.bigfoot.javacalc;

import java.awt.event.ActionListener;

public interface DoubleCalcView extends ActionListener {

    /**
     * Register argument as observer/listener of this; must be done first,
     * before any other methods of this class are called.
     *
     * @param controller
     *            controller to register
     */
    void registerObserver(DoubleCalcController controller);

    /**
     * Updates output.
     *
     * @param d
     *            new value of output
     */
    void updateOutput(Double d);
}