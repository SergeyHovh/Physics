package com.company.basics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

abstract public class CellularAutomata extends GridPanel implements ActionListener {
    private int delay = 100;
    protected boolean toroidal = true;
    Timer timer = new Timer(delay, this);

    protected CellularAutomata(int N, double w, double h) {
        super(N, w, h);
        timer.start();
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public boolean isToroidal() {
        return toroidal;
    }

    public void setToroidal(boolean toroidal) {
        this.toroidal = toroidal;
    }

    protected void populate(double prob) {
        Random r = new Random();
        for (Cell[] cells : getGrid()) {
            for (Cell cell : cells) {
                if (r.nextDouble() < prob)
                    cell.setColor(Color.BLACK);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateGrid(new Rules() {
            @Override
            public void passive(int i, int j, Cell[][] grid) {
                CellularAutomata.this.passive(i, j, grid);
            }

            @Override
            public void active(int i, int j, Cell[][] grid) {
                CellularAutomata.this.active(i, j, grid);
            }
        });
        repaint();
    }


    /**
     * describe active rules of the simulation - behaviour of each cell
     *
     * @param i    number of the current row in the grid
     * @param j    number of the current column in the grid
     * @param grid the grid itself
     */
    protected abstract void active(int i, int j, Cell[][] grid);

    /**
     * describe static or passive rules of the simulation, like heat source
     *
     * @param i    number of the current row in the grid
     * @param j    number of the current column in the grid
     * @param grid the grid itself
     */
    protected abstract void passive(int i, int j, Cell[][] grid);
}
