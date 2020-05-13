package com.company.basics;

import javax.swing.*;
import java.awt.*;

public class Base extends JFrame {
    public Base(String name, int width, int height) {
        super(name);
        setVisible(true);
        setResizable(false);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public Base(String name) {
        this(name, 640, 480);
    }

    public void addComponent(Component comp) {
        super.add(comp);
        comp.setFocusable(true);
        comp.requestFocus();
    }
}
