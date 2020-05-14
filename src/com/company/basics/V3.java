package com.company.basics;

import java.util.Objects;

public class V3 {
    private final V2 xy;
    private final int z;

    public V3(int x, int y, int z) {
        xy = new V2(x, y);
        this.z = z;
    }

    public V3(V2 xy, int z) {
        this(xy.getX(), xy.getY(), z);
    }

    public int getX() {
        return xy.getX();
    }

    public int getY() {
        return xy.getY();
    }

    public int getZ() {
        return z;
    }

    public V2 getXy() {
        return xy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        V3 v3 = (V3) o;
        return z == v3.z &&
                xy.equals(v3.xy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xy, z);
    }
}
