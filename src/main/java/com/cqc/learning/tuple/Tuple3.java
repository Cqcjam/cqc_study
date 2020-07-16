package com.cqc.learning.tuple;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/4.
 */
public class Tuple3<T, K, V> implements Serializable {
    static final long serialVersionUID = 1L;
    public T _1;
    public K _2;
    public V _3;

    public Tuple3(T t, K k, V v) {
        this._1 = t;
        this._2 = k;
        this._3 = v;
    }

    public Tuple3() {
    }
}
