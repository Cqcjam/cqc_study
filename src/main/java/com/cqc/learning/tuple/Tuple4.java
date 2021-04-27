package com.cqc.learning.tuple;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/4.
 */
public class Tuple4<T, K, V, Z> implements Serializable {
    static final long serialVersionUID = 1L;
    public T _1;
    public K _2;
    public V _3;
    public Z _4;

    public Tuple4(T t, K k, V v, Z z) {
        this._1 = t;
        this._2 = k;
        this._3 = v;
        this._4 = z;
    }

    public Tuple4() {
    }
}