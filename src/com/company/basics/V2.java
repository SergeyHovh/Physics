package com.company.basics;

import java.util.Objects;

public class V2<T extends Number> implements MathematicalOperations, V {
    private final T x, y;

    public V2(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    @Override
    public T getZ() {
        return null;
    }

    @Override
    public T getW() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        V2<?> v2 = (V2<?>) o;
        return Objects.equals(x, v2.x) &&
                Objects.equals(y, v2.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "V2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public V add(V v) {
        return new V2<Number>(
                getX().doubleValue() + v.getX().doubleValue(),
                getY().doubleValue() + v.getY().doubleValue()
        );
    }

    @Override
    public V sub(V v) {
        return new V2<Number>(
                getX().doubleValue() - v.getX().doubleValue(),
                getY().doubleValue() - v.getY().doubleValue()
        );
    }

    @Override
    public V mult(V v) {
        return new V2<Number>(
                getX().doubleValue() * v.getX().doubleValue(),
                getY().doubleValue() * v.getY().doubleValue()
        );
    }

    @Override
    public V div(V v) {
        return new V2<Number>(
                getX().doubleValue() / v.getX().doubleValue(),
                getY().doubleValue() / v.getY().doubleValue()
        );
    }
}