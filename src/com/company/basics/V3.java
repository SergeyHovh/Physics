package com.company.basics;

import java.util.Objects;

public class V3<T extends Number> {
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
}
