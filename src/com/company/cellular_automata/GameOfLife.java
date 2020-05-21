package com.company.cellular_automata;

import com.company.basics.Base;
import com.company.basics.Cell;
import com.company.basics.CellularAutomata;

import java.awt.*;
import java.util.Vector;

public class GameOfLife extends CellularAutomata {
    protected Color alive = Color.BLACK;
    protected Color dead = Color.WHITE;

    public GameOfLife(int N, double w, double h) {
        super(N, w, h);
        hideGrid();
        populate(0.2);
        start(100);
    }

    public static void main(String[] args) {
        int dim = 700;
        Base base = new Base("test", dim, dim);
        base.addComponent(new GameOfLife(100, dim, dim));
    }

    @Override
    protected void active(int i, int j, Cell[][] grid) {
        Cell cell = grid[i][j];
        int aliveNeighbor = 0;
        Vector<Cell> neighbors = cell.getNeighbors(getGrid(), true);
        for (Cell neighbor : neighbors) {
            if (neighbor.getColor().equals(alive)) aliveNeighbor++;
        }
        if (cell.getColor().equals(alive)) {
            if (aliveNeighbor == 2 || aliveNeighbor == 3) {
                cell.setColor(alive);
            } else {
                cell.setColor(dead);
            }
        } else {
            if (aliveNeighbor == 3) {
                cell.setColor(alive);
            }
        }
    }

    @Override
    protected void passive(int i, int j, Cell[][] grid) {

    }
}
