package com.educative.io.pattern.util;

import java.util.Random;

public class RandomArrayGenerator {
    private final int size;
    private int bound;


    public RandomArrayGenerator(int size) {
        this.size = size;
    }

    public RandomArrayGenerator setBound(int bound) {
        this.bound = bound;
        return this;
    }

    public int[] getRandomIntArray() {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = (bound > 0) ? random.nextInt(bound) : random.nextInt();
        }
        return array;
    }

    public double[] getRandomDoubleArray() {
        double[] array = new double[this.size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextDouble();
        }
        return array;
    }
}
