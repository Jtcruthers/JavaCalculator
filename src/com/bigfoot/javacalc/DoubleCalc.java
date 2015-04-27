package com.bigfoot.javacalc;

/**
 * A GUI Calculator that works with doubles.
 *
 * @author Justin Carruthers and Ryan Tomlinson
 *
 */
public final class DoubleCalc {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private DoubleCalc() {
    }

    /**
     * Main program that sets up main application window and starts user
     * interaction.
     *
     * @param args
     *            command-line arguments; not used
     */
    public static void main(String[] args) {
        /*
         * Create instances of the model, view, and controller objects;
         * controller needs to know about model and view, and view needs to know
         * about controller
         */

        DoubleCalcModel model = new DoubleCalcModel1();
        DoubleCalcView view = new DoubleCalcView1();
        DoubleCalcController controller = new DoubleCalcController1(model, view);

        view.registerObserver(controller);

    }
}
