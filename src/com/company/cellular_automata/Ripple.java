package com.company.cellular_automata;

import com.company.basics.Base;
import com.company.basics.Cell;
import com.company.basics.CellularAutomata;
import com.company.basics.V3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

import static java.lang.Math.*;

public class Ripple extends CellularAutomata {
    public static void main(String[] args) {
        int dim = 700;
        Base base = new Base("Water Ripple Simulation", dim, dim);
        base.addComponent(new Ripple(100, dim, dim));
    }

    int time = 0;
    Vector<V3<Number>> v3Vector = new Vector<>();

    public Ripple(int N, double w, double h) {
        super(N, w, h);
        start(75);
    }

    @Override
    protected void active(int i, int j, Cell[][] grid) {
        Cell current = grid[i][j];
        float v = 0;
        for (int k = 0; k < v3Vector.size(); k++) {
            V3 v3 = v3Vector.get(k);
            double sq = distanceSq(current, v3.getXy());
            double d = sqrt(sq);
            double localTime = time - (int) v3.getZ();
            double decay = 100 * exp(-d / 3);
            double arg = max(0, min(localTime - d, 5 * PI));
            double r = decay * sin(arg);
            v += max(0, min(localTime - d, r));
            if (i == j && j == 1) {
                System.out.println("v3Vector.size() = " + v3Vector.size());
            }
            if (localTime > 40) {
                v3Vector.remove(k);
            }
        }
        v = max(0, min(v, 1));
        current.setColor(new Color(v, v, v));
    }

    @Override
    protected void passive(int i, int j, Cell[][] grid) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        v3Vector.add(new V3<>(getClickedI(), getClickedJ(), time));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        time++;
    }
}
