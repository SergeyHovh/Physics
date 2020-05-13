package com.company;

import com.company.basics.Base;
import com.company.basics.GridPanel;
import com.company.cellular_automata.GameOfLife;

public class Main extends GridPanel{

    protected Main(int N, double w, double h) {
        super(N, w, h);
    }

    public static void main(String[] args) {
        Base base = new Base("test", 500, 500);
        base.addComponent(new GameOfLife(50, 500, 500));
    }
}
