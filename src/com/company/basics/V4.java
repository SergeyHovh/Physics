package com.company.basics;

import java.util.Objects;

public class V4<T extends Number> implements MathematicalOperations, V {
    private final V2<T> xy, yz, zw;
    private final V3<T> xyz;
    private final T w;

    public V4(T x, T y, T z, T w) {
        xy = new V2<>(x, y);
        yz = new V2<>(y, z);
        zw = new V2<>(z, w);
        xyz = new V3<>(x, y, z);
        this.w = w;
    }

    public V4(V3<T> xyz, T w) {
        this(xyz.getX(), xyz.getY(), xyz.getZ(), w);
    }

    public V2<T> getXy() {
        return xy;
    }

    public V2<T> getYz() {
        return yz;
    }

    public V2<T> getZw() {
        return zw;
    }

    public V3<T> getXyz() {
        return xyz;
    }

    public T getX() {
        return xy.getX();
    }

    public T getY() {
        return xy.getY();
    }

    public T getZ() {
        return xyz.getZ();
    }

    public T getW() {
        return w;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        V4<?> v4 = (V4<?>) o;
        return Objects.equals(xy, v4.xy) &&
                Objects.equals(yz, v4.yz) &&
                Objects.equals(zw, v4.zw) &&
                Objects.equals(xyz, v4.xyz) &&
                Objects.equals(w, v4.w);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xy, yz, zw, xyz, w);
    }

    @Override
    public V add(V v) {
        return new V4<Number>(
                getX().doubleValue() + v.getX().doubleValue(),
                getY().doubleValue() + v.getY().doubleValue(),
                getZ().doubleValue() + v.getZ().doubleValue(),
                getW().doubleValue() + v.getW().doubleValue()
        );
    }

    @Override
    public V sub(V v) {
        return new V4<Number>(
                getX().doubleValue() - v.getX().doubleValue(),
                getY().doubleValue() - v.getY().doubleValue(),
                getZ().doubleValue() - v.getZ().doubleValue(),
                getW().doubleValue() - v.getW().doubleValue()
        );
    }

    @Override
    public V mult(V v) {
        return new V4<Number>(
                getX().doubleValue() * v.getX().doubleValue(),
                getY().doubleValue() * v.getY().doubleValue(),
                getZ().doubleValue() * v.getZ().doubleValue(),
                getW().doubleValue() * v.getW().doubleValue()
        );
    }

    @Override
    public V div(V v) {
        return new V4<Number>(
                getX().doubleValue() / v.getX().doubleValue(),
                getY().doubleValue() / v.getY().doubleValue(),
                getZ().doubleValue() / v.getZ().doubleValue(),
                getW().doubleValue() / v.getW().doubleValue()
        );
    }
}
