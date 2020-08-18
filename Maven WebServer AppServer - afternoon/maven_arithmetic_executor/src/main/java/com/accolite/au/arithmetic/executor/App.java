package com.accolite.au.arithmetic.executor;

import com.accolite.au.arithmetics.base.implementors.ArithmeticOperationsImplementor;
import com.accolite.au.arithmetics.base.interfaces.ArithmeticOperations;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Enter two numbers to find sum, difference, product and quotient:");
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();

        ArithmeticOperations arith = new ArithmeticOperationsImplementor();

        System.out.println("Sum of " + a + " and " + b + " is " + arith.add(a,b));
        System.out.println("Difference of " + a + " and " + b + " is " + arith.sub(a,b));
        System.out.println("Product of " + a + " and " + b + " is " + arith.mul(a,b));
        System.out.println("Quotient of " + a + " and " + b + " is " + arith.div(a,b));
    }
}
