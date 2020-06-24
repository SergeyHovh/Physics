package com.company.basics;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

public class Cell extends Rectangle2D.Double {
    private Color color;
    private int i, j;
    private Map<String, Object> params = new HashMap<>();

    public Cell(double x, double y, double w, double h) {
        super(x * w, y * h, w, h);
        this.i = (int) x;
        this.j = (int) y;
        color = Color.WHITE;
    }

    public Vector<Cell> getNeighbors(Cell[][] grid, boolean toroidal) {
        Vector<Cell> result = new Vector<>();
        int rows = grid.length;
        int cols = grid[0].length;

        if (toroidal) {
            result.add(grid[(i - 1 + rows) % rows][j]);
            result.add(grid[(i + 1 + rows) % rows][j]);
            result.add(grid[i][(j - 1 + cols) % cols]);
            result.add(grid[i][(j + 1 + cols) % cols]);
            result.add(grid[(i - 1 + rows) % rows][(j - 1 + cols) % cols]);
            result.add(grid[(i - 1 + rows) % rows][(j + 1 + cols) % cols]);
            result.add(grid[(i + 1 + rows) % rows][(j - 1 + cols) % cols]);
            result.add(grid[(i + 1 + rows) % rows][(j + 1 + cols) % cols]);
        } else {
            if (i > 0) result.add(grid[i - 1][j]);
            if (i < rows - 1) result.add(grid[i + 1][j]);
            if (j > 0) result.add(grid[i][j - 1]);
            if (j < cols - 1) result.add(grid[i][j + 1]);
            if (i > 0 && j > 0) result.add(grid[i - 1][j - 1]);
            if (i > 0 && j < cols - 1) result.add(grid[i - 1][j + 1]);
            if (i < rows - 1 && j > 0) result.add(grid[i + 1][j - 1]);
            if (i < rows - 1 && j < cols - 1) result.add(grid[i + 1][j + 1]);
        }

        return result;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cell cell = (Cell) o;
        return i == cell.i &&
                j == cell.j &&
                Objects.equals(color, cell.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, i, j);
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParam(String key, Object value) {
        params.put(key, value);
    }

    public Object getParam(String key) {
        return params.get(key);
    }
}
