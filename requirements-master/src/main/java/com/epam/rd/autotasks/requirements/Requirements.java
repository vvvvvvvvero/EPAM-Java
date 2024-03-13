package com.epam.rd.autotasks.requirements;

import java.io.IOException;

public class Requirements {

    public static void requireNonNull(Object obj) throws NullPointerException {
        if (obj == null)
        {
            throw new NullPointerException();
        }

    }

    public static void requireNonNull(Object obj, String message) {
        if (obj == null)
        {
            throw new NullPointerException(message);
        }

    }

    public static void checkArgument(boolean value) {
        if (!value)
        {
            throw new IllegalArgumentException();
        }

    }

    public static void checkArgument(boolean value, String message) {
        if (!value)
        {
            throw new IllegalArgumentException(message);
        }

    }

    public static void checkState(boolean value) {
        if (!value)
        {
            throw new IllegalStateException();
        }

    }

    public static void checkState(boolean value, String message) {
        if (!value)
        {
            throw new IllegalStateException(message);
        }

    }

    public static void checkIndex(int index, int size) {
        if (index < 0 || index > size - 1)
        {
            throw new IndexOutOfBoundsException();
        }
    }


}
