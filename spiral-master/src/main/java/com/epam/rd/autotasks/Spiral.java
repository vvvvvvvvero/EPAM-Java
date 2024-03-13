package com.epam.rd.autotasks;

class Spiral
{
    static int[][] spiral(int rows, int columns)
    {

        int [][] spiralArray = new int[rows][columns];
        int numberOfElements = rows * columns;
        int [] testArray = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++)
        {
            testArray[i] = i + 1;
        }

        int top = 0,
                bottom = rows - 1,
                left = 0,
                right = columns - 1;

        int index = 0;

        while (true)
        {
            if (left > right)
                break;

            for (int i = left; i <= right; i++)
                spiralArray[top][i] = testArray[index++];
            top++;

            if (top > bottom)
                break;

            for (int i = top; i <= bottom; i++)
                spiralArray[i][right] = testArray[index++];
            right--;

            if (left > right)
                break;

            for (int i = right; i >= left; i--)
                spiralArray[bottom][i] = testArray[index++];
            bottom--;

            if (top > bottom)
                break;

            for (int i = bottom; i >= top; i--)
                spiralArray[i][left] = testArray[index++];
            left++;
        }
        return spiralArray;
    }
}
