package com.example;

import com.example.model.Matrix;
import com.example.service.MatrixMathematics;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by eng_r on 03/12/2018.
 */
public class MatrixTest {

    @Test
    public void isSquare() throws Exception {
        Matrix matrix = new Matrix(2,2);
        matrix.setValueAt(0,0,1);
        matrix.setValueAt(0,1,2);
        matrix.setValueAt(1,0,3);
        matrix.setValueAt(1,1,4);
        assertTrue(matrix.isSquare());
    }

    @Test
    public void size() throws Exception {
        Matrix matrix = new Matrix(2,2);
        matrix.setValueAt(0,0,1);
        matrix.setValueAt(0,1,2);
        matrix.setValueAt(1,0,3);
        matrix.setValueAt(1,1,4);
        assertEquals(matrix.size(), 2);
    }

    @Test
    public void multiplyByConstant() throws Exception {
        Matrix matrix = new Matrix(2,2);
        matrix.setValueAt(0,0,1);
        matrix.setValueAt(0,1,2);
        matrix.setValueAt(1,0,3);
        matrix.setValueAt(1,1,4);
        Matrix res = new Matrix(2,2);
        res.setValueAt(0,0,2);
        res.setValueAt(0,1,4);
        res.setValueAt(1,0,6);
        res.setValueAt(1,1,8);
        assertArrayEquals((matrix.multiplyByConstant(2)).getValues()[0], res.getValues()[0], 0);
        assertArrayEquals((matrix.multiplyByConstant(2)).getValues()[1], res.getValues()[1], 0);
    }

    @Test
    public void getValues() throws Exception {
        Matrix matrix = new Matrix(2,2);
        matrix.setValueAt(0,0,1);
        matrix.setValueAt(0,1,2);
        matrix.setValueAt(1,0,3);
        matrix.setValueAt(1,1,4);
        double [] res0 = {1, 2};
        double [] res1 = {3, 4};
        assertArrayEquals(matrix.getValues()[0], res0, 0);
        assertArrayEquals(matrix.getValues()[1], res1, 0);
    }

}
