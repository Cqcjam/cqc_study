package com.cqc.learning.tuple;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Administrator on 2015/4/24.
 */
public class Tuple2<T, K> implements Serializable {
    static final long serialVersionUID = 1L;
    public T _1;
    public K _2;

    public Tuple2(T t, K k) {
        this._1 = t;
        this._2 = k;
    }

    public Tuple2() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(_1, tuple2._1);
    }

    @Override
    public int hashCode() {

        return Objects.hash(_1);
    }
}
