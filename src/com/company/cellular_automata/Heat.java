package com.company.cellular_automata;

import com.company.basics.Cell;
import com.company.basics.CellularAutomata;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class Heat extends CellularAutomata {

    public Heat(int N, double w, double h) {
        super(N, w, h);
        hideGrid();
        setDelay(100);
        setToroidal(false);
    }

    @Override
    protected void active(int i, int j, Cell[][] grid) {
        Cell current = grid[i][j];
        Vector<Cell> neighbors = current.getNeighbors(getGrid(), isToroidal());
        float r = 0f, g = 0f, b = 0f;
        for (Cell neighbor : neighbors) {
            r += neighbor.getColor().getRed();
            g += neighbor.getColor().getGreen();
            b += neighbor.getColor().getBlue();
        }
        int size = 255 * neighbors.size();
        r /= size;
        g /= size;
        b /= size;
        current.setColor(new Color(r, g, b));
    }

    @Override
    protected void passive(int i, int j, Cell[][] grid) {
    }

    private void setSource(Cell sourceOfHeat, Color warmth) {
        sourceOfHeat.setColor(warmth);
        Vector<Cell> sourceNeighbors = sourceOfHeat.getNeighbors(getGrid(), isToroidal());
        for (Cell neighbor : sourceNeighbors) {
            neighbor.setColor(warmth);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Cell clicked = getGrid()[getClickedI()][getClickedJ()];
        setSource(clicked, Color.RED);
    }
}
