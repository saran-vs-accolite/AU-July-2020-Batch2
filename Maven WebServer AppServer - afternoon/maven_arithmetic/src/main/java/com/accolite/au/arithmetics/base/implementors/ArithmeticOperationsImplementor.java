package com.accolite.au.arithmetics.base.implementors;

import com.accolite.au.arithmetics.base.interfaces.ArithmeticOperations;

public class ArithmeticOperationsImplementor implements ArithmeticOperations {
    public int add(int a, int b) {
        return a+b;
    }

    public int sub(int a, int b) {
        return a-b;
    }

    public int mul(int a, int b) {
        return a*b;
    }

    public int div(int a, int b) {
        return a/b;
    }
}
