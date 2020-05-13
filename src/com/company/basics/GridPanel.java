package com.company.basics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GridPanel extends JPanel implements MouseListener, KeyListener {

    public interface Rules {
        void action(int i, int j, Cell[][] grid);
    }

    private final int N;
    private final Cell[][] grid, gridCopy;
    private final double scaleX, scaleY;
    private int I, J;
    private boolean showGrid = true;

    protected GridPanel(int N, double w, double h) {
        this.N = N;
        this.grid = new Cell[N][N];
        this.gridCopy = new Cell[N][N];
        this.scaleX = (w - 10) / N;
        this.scaleY = (h - 35) / N;
        addMouseListener(this);
        addKeyListener(this);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = new Cell(i, j, scaleX, scaleY);
                gridCopy[i][j] = new Cell(i, j, scaleX, scaleY);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for (Cell[] rectangle2DS : grid) {
            for (Cell rectangle2D : rectangle2DS) {
                graphics2D.setColor(rectangle2D.getColor());
                graphics2D.fill(rectangle2D);
                if(showGrid) {
                    graphics2D.setColor(Color.BLACK);
                    graphics2D.draw(rectangle2D);
                }
            }
        }
    }

    void updateGrid(Rules rule) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rule.action(i, j, gridCopy);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j].setColor(gridCopy[i][j].getColor());
            }
        }
    }

    public Cell[][] getGridCopy() {
        return gridCopy;
    }

    protected void showGrid() {
        showGrid = true;
    }

    protected void hideGrid() {
        showGrid = false;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public int getN() {
        return N;
    }

    public int getClickedI() {
        return I;
    }

    public int getClickedJ() {
        return J;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.I = (int) (e.getX() / scaleX);
        this.J = (int) (e.getY() / scaleY);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        repaint();
    }
}
