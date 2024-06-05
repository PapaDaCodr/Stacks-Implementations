package com.OseiOwusuAnsah.Assignment1;

public interface StackADT<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
