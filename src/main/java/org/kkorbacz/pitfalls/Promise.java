package org.kkorbacz.pitfalls;

import java.util.function.Function;

public class Promise<T> {

    private T value;

    public Promise(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public <O> Promise<O> map(Function<? super T, ? extends O> trasnformer) {
        return new Promise<>(trasnformer.apply(value));
    }


}
