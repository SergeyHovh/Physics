package com.company.basics;

import java.util.Objects;

public class V2 {
    private final int x, y;

    public V2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        V2 v2 = (V2) o;
        return x == v2.x &&
                y == v2.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}