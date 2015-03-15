package com.bigfoot.javacalc;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Ryan
 *
 */
public final class DoubleCalcView1 extends JFrame implements DoubleCalcView {

    /**
     *
     */
    private static final long serialVersionUID = 1;

    /**
     *
     */
    private DoubleCalcController controller;

    /**
     *
     * This enum allows us to know what button was just hit. This will help us
     * determine what to do next.
     *
     *
     */
    private static enum State {

        SAW_CLEAR,
        SAW_ENTER,
        SAW_OTHER_OP,
        SAW_DIGIT,
        SAW_ADD,
        SAW_SUB,
        SAW_ROOT,
        SAW_SQUARE,
        SAW_MULTIPLY,
        SAW_DIVIDE,
        SAW_POSNEG,
        SAW_DEC

    }

    /**
     *
     */
    private State currentState;

    /**
     *
     */
    private final JTextArea tOutput;

    /**
     *
     */
    private final JButton bClear, bEnter, bAdd, bSubtract, bMultiply, bDivide,
            bSquare, bSquareRoot, bDecimal, bPosNeg;

    /**
     *
     */
    private final JButton[] bDigits;

    /**
     *
     */
    private static final int TEXT_AREA_HEIGHT = 3, TEXT_AREA_WIDTH = 13,
            DIGIT_BUTTONS = 10, MAIN_BUTTON_PANEL_GRID_ROWS = 4,
            MAIN_BUTTON_PANEL_GRID_COLUMNS = 3,
            SIDE_BUTTON_PANEL_GRID_ROWS = 4,
            SIDE_BUTTON_PANEL_GRID_COLUMNS = 2, CALC_GRID_ROWS = 2,
            CALC_GRID_COLUMNS = 1;

    /**
     *
     */
    public DoubleCalcView1() {

        super("Calculator");

        // Set up the GUI widgets
        this.currentState = State.SAW_CLEAR;

        // Text Area
        this.tOutput = new JTextArea("", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.tOutput.setEditable(false);

        // Disable buttons

        // TODO - I don't think we should ever have to disable buttons because
        // we can just use if statements to see if there's anything in the text
        // box and if there isn't we just do nothing.

        // I'm not sure. We will have to talk about it.

        // Create scroll pane
        JScrollPane outputTextScroll = new JScrollPane(this.tOutput);

        // Create main button panel

        JPanel mainButtonPanel = new JPanel(new GridLayout(
                MAIN_BUTTON_PANEL_GRID_ROWS, MAIN_BUTTON_PANEL_GRID_COLUMNS));

        // Add buttons to the main button panel

        this.bDigits = new JButton[DIGIT_BUTTONS];
        for (int i = 0; i < DIGIT_BUTTONS; i++) {
            String num = Integer.toString(i);
            this.bDigits[i] = new JButton(num);
        }

        this.bAdd = new JButton("+");
        this.bSubtract = new JButton("-");
        this.bMultiply = new JButton("x");
        this.bDivide = new JButton("/");
        this.bDecimal = new JButton(".");
        this.bClear = new JButton("AC");
        this.bEnter = new JButton("=");
        this.bPosNeg = new JButton("+/-");
        this.bSquare = new JButton("Square");
        this.bSquareRoot = new JButton("Square Root");

        mainButtonPanel.add(this.bDigits[7]);
        mainButtonPanel.add(this.bDigits[8]);
        mainButtonPanel.add(this.bDigits[9]);

        mainButtonPanel.add(this.bDigits[4]);
        mainButtonPanel.add(this.bDigits[5]);
        mainButtonPanel.add(this.bDigits[6]);

        mainButtonPanel.add(this.bDigits[1]);
        mainButtonPanel.add(this.bDigits[2]);
        mainButtonPanel.add(this.bDigits[3]);

        mainButtonPanel.add(this.bDigits[0]);
        mainButtonPanel.add(this.bDecimal);
        mainButtonPanel.add(this.bPosNeg);

        // Create side button panel and add buttons to it

        JPanel sideButtonPanel = new JPanel(new GridLayout(
                SIDE_BUTTON_PANEL_GRID_ROWS, SIDE_BUTTON_PANEL_GRID_COLUMNS));

        sideButtonPanel.add(this.bClear);
        sideButtonPanel.add(this.bDivide);

        sideButtonPanel.add(this.bMultiply);
        sideButtonPanel.add(this.bSquareRoot);

        sideButtonPanel.add(this.bSubtract);
        sideButtonPanel.add(this.bSquare);

        sideButtonPanel.add(this.bAdd);
        sideButtonPanel.add(this.bEnter);

        // Create combined button panel organized using FlowLayout

        JPanel combinedPanel = new JPanel(new FlowLayout());

        // Add the other two button panels to the combined button panel

        combinedPanel.add(mainButtonPanel);
        combinedPanel.add(sideButtonPanel);

        // Organize main window

        this.setLayout(new GridLayout(CALC_GRID_ROWS, CALC_GRID_COLUMNS));

        // Add scroll pane and button panel to main window

        this.add(outputTextScroll);
        this.add(combinedPanel);

        // Register this object as the observer for all GUI events

        this.bClear.addActionListener(this);
        this.bEnter.addActionListener(this);
        this.bAdd.addActionListener(this);
        this.bSubtract.addActionListener(this);
        this.bMultiply.addActionListener(this);
        this.bDivide.addActionListener(this);
        this.bSquare.addActionListener(this);
        this.bSquareRoot.addActionListener(this);
        this.bDecimal.addActionListener(this);
        this.bPosNeg.addActionListener(this);

        this.bDigits[0].addActionListener(this);
        this.bDigits[1].addActionListener(this);
        this.bDigits[2].addActionListener(this);
        this.bDigits[3].addActionListener(this);
        this.bDigits[4].addActionListener(this);
        this.bDigits[5].addActionListener(this);
        this.bDigits[6].addActionListener(this);
        this.bDigits[7].addActionListener(this);
        this.bDigits[8].addActionListener(this);
        this.bDigits[9].addActionListener(this);

        // Window settings

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        //Set the cursor to wait
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        //Determine which event happens
        Object source = event.getSource();
        if (source == this.bClear) {
            this.controller.processClearEvent();
            this.currentState = State.SAW_CLEAR;
        } else if (source == this.bEnter) {
            this.controller.processEnterEvent();
            this.currentState = State.SAW_ENTER;
        } else if (source == this.bAdd) {
            this.controller.processAddEvent();
            this.currentState = State.SAW_ADD;
        } else if (source == this.bSubtract) {
            this.controller.processSubtractEvent();
            this.currentState = State.SAW_SUB;
        } else if (source == this.bMultiply) {
            this.controller.processMultiplyEvent();
            this.currentState = State.SAW_MULTIPLY;
        } else if (source == this.bDivide) {
            this.controller.processDivideEvent();
            this.currentState = State.SAW_DIVIDE;
        } else if (source == this.bSquare) {
            this.controller.processSquareEvent();
            this.currentState = State.SAW_SQUARE;
        } else if (source == this.bSquareRoot) {
            this.controller.processSquareRootEvent();
            this.currentState = State.SAW_ROOT;
        } else if (source == this.bPosNeg) {
            this.controller.processPosNegEvent();
            this.currentState = State.SAW_POSNEG;
        } else {
            for (int i = 0; i < DIGIT_BUTTONS; i++) {
                if (source == this.bDigits[i]) {
                    switch (this.currentState) {
                        case SAW_ENTER:
                            this.controller.processClearEvent();
                            break;
                        case SAW_ADD:
                            break;
                        case SAW_SUB:
                            break;
                        case SAW_MULTIPLY:
                            break;
                        case SAW_DIVIDE:
                            break;
                        case SAW_SQUARE:
                            break;
                        case SAW_ROOT:
                            break;
                        case SAW_DIGIT:
                            double counter = i;
                            this.controller.processAddDigit(counter);
                            break;
                        default:
                            break;
                    }
                    this.controller.processAddDigit(i);
                    this.currentState = State.SAW_DIGIT;
                    break;
                }
            }
        }
    }

    @Override
    public void registerObserver(DoubleCalcController controller) {
        this.controller = controller;

    }

    //We might need to change this. I'm not sure yet.
    @Override
    public void updateInput1(Double d) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateInput2(Double d) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateOutput(Double d) {
        // TODO Auto-generated method stub

    }

}