package com.company.cellular_automata;

import com.company.basics.Base;
import com.company.basics.Cell;
import com.company.basics.CellularAutomata;

public class Fire extends CellularAutomata {
    protected Fire(int N, double w, double h) {
        super(N, w, h);
        start(100);
    }

    public static void main(String[] args) {
        int dim = 700;
        Base base = new Base("fire simulation", dim, dim);
        base.addComponent(new Fire(100, dim, dim));
    }

    @Override
    protected void active(int i, int j, Cell[][] grid) {

    }

    @Override
    protected void passive(int i, int j, Cell[][] grid) {

    }
}