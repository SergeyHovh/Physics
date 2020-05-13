package com.company.cellular_automata;

import com.company.basics.Cell;
import com.company.basics.CellularAutomata;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

import static java.lang.Math.*;

public class Ripple extends CellularAutomata {
    int time = 0;
    Vector<V2> v2Vector = new Vector<>();

    public Ripple(int N, double w, double h) {
        super(N, w, h);
    }

    @Override
    protected void active(int i, int j, Cell[][] grid) {
        Cell current = grid[i][j];
        float v = 0;
        for (V2 v2 : v2Vector) {
            double sq = distanceSq(current, v2);
            double d = sqrt(sq);
            double r = (sin(d - time)) * exp(-d / 5) * 10;
            v += r;
        }
        v = max(0, min(v, 1));
        current.setColor(new Color(v, v, v));
    }

    @Override
    protected void passive(int i, int j, Cell[][] grid) {

    }

    double distanceSq(Cell current, V2 v2) {
        int i = current.getI() - v2.i;
        int j = current.getJ() - v2.j;
        return i * i + j * j;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        v2Vector.add(new V2(getClickedI(), getClickedJ()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        time++;
        if (time > 100) time = 0;
    }

    private static class V2 {
        private final int i;
        private final int j;

        public V2(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
