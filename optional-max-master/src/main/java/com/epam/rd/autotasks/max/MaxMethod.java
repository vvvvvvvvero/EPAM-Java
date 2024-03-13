package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        OptionalInt result;
        if (values != null && values.length > 0) {
            result = OptionalInt.of(maxValue(values));
        }
        else {
            result = OptionalInt.empty();
        }
        return result;
    }

    public static int maxValue(int [] values) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

}
