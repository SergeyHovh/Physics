package com.company;

import com.company.basics.Base;
import com.company.basics.GridPanel;
import com.company.cellular_automata.Ripple;

public class Main extends GridPanel{

    protected Main(int N, double w, double h) {
        super(N, w, h);
    }

    public static void main(String[] args) {
        Base base = new Base("test", 500, 500);
        base.addComponent(new Ripple(100, 500, 500));
    }
}
