package org.example;


import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class JOptional<T> {
    private T value;


    public JOptional(){
        value=null;
    }

    public JOptional(T t) {
        this.value=t;
    }

    public static <T> JOptional<T> ofNullable(T t) {
        if(t==null){
            return new JOptional<T>();
        }
        else{
            return new JOptional<T>(t);
        }
    }

    public <U> JOptional<U> map(Function<T, U> mapper) {
        if (value==null) {
            return new JOptional();
        } else {
            return JOptional.ofNullable(mapper.apply(value));
        }
    }

    public Stream<T> stream() {
        if(value==null) {
            return Stream.of();
        }
        else
        return Stream.of(value);

    }

    public T get() {
        return this.value;
    }

    public T orElse(T backup) {
        if(value==null){
            return backup;
        }
        else return this.value;
    }

    public T orElseGet(Supplier<T> backupCallback) {
        if(value==null){
            return backupCallback.get();
        }
        else return this.value;
    }
}
