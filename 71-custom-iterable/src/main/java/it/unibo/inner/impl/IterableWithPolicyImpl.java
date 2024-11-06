package it.unibo.inner.impl;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{
    private final T[] arrayList;
    private final int size;
    Predicate<T> filter;

    public IterableWithPolicyImpl(final T[] arrayList, Predicate<T> filter){
        this.arrayList = arrayList;
        size = arrayList.length;
        this.filter = filter;
    }

    public IterableWithPolicyImpl(final T[] arrayList){
        this(arrayList, new Predicate<>() {
            public boolean test(T elem) {
                return true;
            }
        });
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter){
       this.filter = filter;
    }

    @Override
    public Iterator<T> iterator(){
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T>{
        private int count = 0;

        @Override
        public boolean hasNext(){
            while(count < size && arrayList[count] != null && !filter.test(arrayList[count])){
                count++;
            }
            return count < size;
        }

        @Override
        public T next(){
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return arrayList[count++];
        }
    }
}