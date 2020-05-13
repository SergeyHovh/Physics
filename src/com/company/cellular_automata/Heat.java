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
        setDelay(200);
        populate(0.5);
    }

    @Override
    protected void rules(int i, int j, Cell[][] grid) {
        Cell current = grid[i][j];
        Vector<Cell> neighbors = current.getNeighbors(getGrid(), true);
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
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Cell clicked = getGrid()[getClickedI()][getClickedJ()];
        clicked.setColor(Color.RED);
        Vector<Cell> neighbors = clicked.getNeighbors(getGrid(), true);
        for (Cell neighbor : neighbors) {
            neighbor.setColor(Color.RED);
            Vector<Cell> neighbors1 = neighbor.getNeighbors(getGrid(), true);
            for (Cell cell : neighbors1) {
                cell.setColor(Color.RED);
            }
        }

    }
}
