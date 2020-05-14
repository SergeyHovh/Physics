package com.company.basics;

import java.util.Objects;

public class V4 {
    private final V2 xy, yz, zw;
    private final V3 xyz;
    private final int w;

    public V4(int x, int y, int z, int w) {
        xy = new V2(x, y);
        yz = new V2(y, z);
        zw = new V2(z, w);
        xyz = new V3(x, y, z);
        this.w = w;
    }

    public V4(V3 xyz, int w) {
        this(xyz.getX(), xyz.getY(), xyz.getZ(), w);
    }

    public V2 getXy() {
        return xy;
    }

    public V2 getYz() {
        return yz;
    }

    public V2 getZw() {
        return zw;
    }

    public V3 getXyz() {
        return xyz;
    }

    public int getX() {
        return xy.getX();
    }

    public int getY() {
        return xy.getY();
    }

    public int getZ() {
        return xyz.getZ();
    }

    public int getW() {
        return w;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        V4 v4 = (V4) o;
        return w == v4.w &&
                Objects.equals(xy, v4.xy) &&
                Objects.equals(yz, v4.yz) &&
                Objects.equals(zw, v4.zw) &&
                Objects.equals(xyz, v4.xyz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xy, yz, zw, xyz, w);
    }
}
