package com.example;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.example.exception.NoSquareException;
import com.example.model.Matrix;
import com.example.service.*;
import org.junit.*;

/**
 * Created by REBATCHI Hocine 2CS SIL1
 */

public class MatrixMathematicsTest {

    @Test
    public void determinant() throws Exception {
        Matrix matrix = new Matrix(2,2);
        matrix.setValueAt(0,0,1);
        matrix.setValueAt(0,1,2);
        matrix.setValueAt(1,0,3);
        matrix.setValueAt(1,1,4);
        assertEquals(MatrixMathematics.determinant(matrix), -2,0);
    }

    @Test
    public void cofactor() throws Exception {
        Matrix matrix = new Matrix(2,2);
        matrix.setValueAt(0,0,1);
        matrix.setValueAt(0,1,2);
        matrix.setValueAt(1,0,3);
        matrix.setValueAt(1,1,4);
        Matrix res = new Matrix(2,2);
        res.setValueAt(0,0,4);
        res.setValueAt(0,1,-3);
        res.setValueAt(1,0,-2);
        res.setValueAt(1,1,1);
        assertArrayEquals((MatrixMathematics.cofactor(matrix)).getValues()[0], res.getValues()[0], 0);
        assertArrayEquals((MatrixMathematics.cofactor(matrix)).getValues()[1], res.getValues()[1], 0);
    }

}