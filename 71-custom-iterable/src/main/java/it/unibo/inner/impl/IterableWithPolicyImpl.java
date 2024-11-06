package it.unibo.inner.impl;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{
    private final T[] arrayList;
    private final int size;

    public IterableWithPolicyImpl(final T[] arrayList){
        this.arrayList = arrayList;
        size = arrayList.length;
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter){
       
    }

    @Override
    public Iterator<T> iterator(){
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T>{
        private int count = 0;

        @Override
        public boolean hasNext(){
            return count < size && arrayList[count] != null;
        }

        @Override
        public T next(){
            return arrayList[count++];
        }
    }
}