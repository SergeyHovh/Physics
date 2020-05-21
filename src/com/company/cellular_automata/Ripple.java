package com.company.cellular_automata;

import com.company.basics.Cell;
import com.company.basics.CellularAutomata;
import com.company.basics.V2;
import com.company.basics.V3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

import static java.lang.Math.*;

public class Ripple extends CellularAutomata {
    int time = 0;
    Vector<V3<Number>> v3Vector = new Vector<>();

    public Ripple(int N, double w, double h) {
        super(N, w, h);
    }

    @Override
    protected void active(int i, int j, Cell[][] grid) {
        Cell current = grid[i][j];
        float v = 0;
        for (V3 v3 : v3Vector) {
            double sq = distanceSq(current, v3.getXy());
            double d = sqrt(sq);
            double localTime = time - (int) v3.getZ();
            double decay = 100 * exp(-d / 5);
            double r = decay * sin(d - localTime);
            v += max(0, min(localTime - d, r));
        }
        v = max(0, min(v, 1));
        current.setColor(new Color(v, v, v));
    }

    @Override
    protected void passive(int i, int j, Cell[][] grid) {

    }

    double distanceSq(Cell current, V2 v2) {
        int i = current.getI() - v2.getX();
        int j = current.getJ() - v2.getY();
        return i * i + j * j;
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
