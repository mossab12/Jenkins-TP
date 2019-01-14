package com.example;

import com.example.exception.NoSquareException;
import com.example.model.Matrix;
import com.example.service.MatrixMathematics;
import org.junit.*;

/**
 * Created by eng_r on 03/12/2018.
 */

public class NoSquareExceptionTest {

    @Test(expected = NoSquareException.class)
    public void isSquare() throws Exception {
        Matrix matrix = new Matrix(1,2);
        matrix.setValueAt(0,0,1);
        matrix.setValueAt(0,1,2);
        double det = MatrixMathematics.determinant(matrix);
    }

}
