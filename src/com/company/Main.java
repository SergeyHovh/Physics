package com.company;

import com.company.basics.GridPanel;
import com.company.basics.V2;
import com.company.basics.V3;


public class Main extends GridPanel{

    protected Main(int N, double w, double h) {
        super(N, w, h);
    }

    public static void main(String[] args) {
        V2<Integer> integerV21 = new V2<>(2, 3);
        V2<Integer> integerV22 = new V2<>(4, 5);
        System.out.println(integerV21.div(integerV22));

        V3<Number> numberV31 = new V3<>(1, 2, 3);
        V3<Number> numberV32 = new V3<>(2, 3, 4);
        System.out.println(numberV31.mult(numberV32));
    }
}
