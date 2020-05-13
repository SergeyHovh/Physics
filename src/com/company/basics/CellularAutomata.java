package com.company.basics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

abstract public class CellularAutomata extends GridPanel implements ActionListener {
    Timer timer = new Timer(100, this);

    protected CellularAutomata(int N, double w, double h) {
        super(N, w, h);
        timer.start();
    }

    protected void seed(double prob) {
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
        updateGrid(this::rules);
        repaint();
    }

    protected abstract void rules(int i, int j, Cell[][] grid);
}
