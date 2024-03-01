package com.pattern.util;

import java.util.Random;

public class RandomArrayGenerator {
    private int size;


    public RandomArrayGenerator(int size) {
        this.size = size;
    }

    public int[] getRandomIntArray() {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
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
