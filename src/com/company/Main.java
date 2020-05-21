package com.company;

import com.company.basics.GridPanel;
import com.company.basics.V2;


public class Main extends GridPanel{

    protected Main(int N, double w, double h) {
        super(N, w, h);
    }

    public static void main(String[] args) {
//        int dim = 700;
//        Base base = new Base("test", dim, dim);
//        base.addComponent(new Ripple(100, dim, dim));
        V2<Integer> v1 = new V2<>(2, 3);
        V2<Integer> v2 = new V2<>(4, 5);
        System.out.println(v1.div(v2));
    }
}
