package com.company.basics;

import java.util.Objects;

public class V3<T extends Number> implements MathematicalOperations, V {
    private final V2<T> xy;
    private final T z;

    public V3(T x, T y, T z) {
        xy = new V2<>(x, y);
        this.z = z;
    }

    public V3(V2<T> xy, T z) {
        this(xy.getX(), xy.getY(), z);
    }

    public T getX() {
        return xy.getX();
    }

    public T getY() {
        return xy.getY();
    }

    public T getZ() {
        return z;
    }

    @Override
    public T getW() {
        return null;
    }

    public V2<T> getXy() {
        return xy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        V3<?> v3 = (V3<?>) o;
        return Objects.equals(xy, v3.xy) &&
                Objects.equals(z, v3.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xy, z);
    }

    @Override
    public String toString() {
        return "V3{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", z=" + getZ() +
                '}';
    }

    @Override
    public V add(V v) {
        return new V3<Number>(
                getX().doubleValue() + v.getX().doubleValue(),
                getY().doubleValue() + v.getY().doubleValue(),
                getZ().doubleValue() + v.getZ().doubleValue()
        );
    }

    @Override
    public V sub(V v) {
        return new V3<Number>(
                getX().doubleValue() - v.getX().doubleValue(),
                getY().doubleValue() - v.getY().doubleValue(),
                getZ().doubleValue() - v.getZ().doubleValue()
        );
    }

    @Override
    public V mult(V v) {
        return new V3<Number>(
                getX().doubleValue() * v.getX().doubleValue(),
                getY().doubleValue() * v.getY().doubleValue(),
                getZ().doubleValue() * v.getZ().doubleValue()
        );
    }

    @Override
    public V div(V v) {
        return new V3<Number>(
                getX().doubleValue() / v.getX().doubleValue(),
                getY().doubleValue() / v.getY().doubleValue(),
                getZ().doubleValue() / v.getZ().doubleValue()
        );
    }
}
