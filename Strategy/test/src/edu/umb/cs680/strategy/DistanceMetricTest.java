package edu.umb.cs680.strategy;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceMetricTest {
    @Test
    public void euclideanMatrixCalculation() {
        List<List<Double>> expected = Arrays.asList(
                Arrays.asList(0.0, 16.97056274847714, 8.54400374531753, 7.483314773547883, 12.767145334803704),
                Arrays.asList(16.97056274847714, 0.0, 21.93171219946131, 20.97617696340303, 4.358898943540674),
                Arrays.asList(8.54400374531753, 21.93171219946131, 0.0, 2.23606797749979, 18.384776310850235),
                Arrays.asList(7.483314773547883, 20.97617696340303, 2.23606797749979, 0.0, 17.291616465790582),
                Arrays.asList(12.767145334803704, 4.358898943540674, 18.384776310850235, 17.291616465790582, 0.0));

        List<List<Double>> input = Arrays.asList(
                Arrays.asList(-2.0, -2.0, 8.0),
                Arrays.asList(10.0, -2.0, -4.0),
                Arrays.asList(-8.0,4.0,7.0),
                Arrays.asList(-8.0,2.0,6.0),
                Arrays.asList(7.0,-3.0,-1.0));
        List<List<Double>> res = Distance.matrix(input, new Euclidean());

        System.out.println("Euclidean");
        System.out.println(res);

        assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test
    public void manhattanMatrixCalculation() {
        List<List<Double>> expected = Arrays.asList(
                Arrays.asList(0.0, 24.0, 13.0, 12.0, 19.0),
                Arrays.asList(24.0, 0.0, 35.0, 32.0, 7.0),
                Arrays.asList(13.0, 35.0, 0.0, 3.0, 30.0),
                Arrays.asList(12.0, 32.0, 3.0, 0.0, 27.0),
                Arrays.asList(19.0, 7.0, 30.0, 27.0, 0.0));

        List<List<Double>> input = Arrays.asList(
                Arrays.asList(-2.0, -2.0, 8.0),
                Arrays.asList(10.0, -2.0, -4.0),
                Arrays.asList(-8.0,4.0,7.0),
                Arrays.asList(-8.0,2.0,6.0),
                Arrays.asList(7.0,-3.0,-1.0));
        List<List<Double>> res = Distance.matrix(input, new Manhattan());

        System.out.println("Manhattan");
        System.out.println(res);

        assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test
    public void chebyshevMatrixCalculation() {
        List<List<Double>> expected = Arrays.asList(
                Arrays.asList(0.0, 12.0, 6.0, 6.0, 9.0),
                Arrays.asList(12.0, 0.0, 18.0, 18.0, 3.0),
                Arrays.asList(6.0, 18.0, 0.0, 2.0, 15.0),
                Arrays.asList(6.0, 18.0, 2.0, 0.0, 15.0),
                Arrays.asList(9.0, 3.0, 15.0, 15.0, 0.0));

        List<List<Double>> input = Arrays.asList(
                Arrays.asList(-2.0, -2.0, 8.0),
                Arrays.asList(10.0, -2.0, -4.0),
                Arrays.asList(-8.0,4.0,7.0),
                Arrays.asList(-8.0,2.0,6.0),
                Arrays.asList(7.0,-3.0,-1.0));
        List<List<Double>> res = Distance.matrix(input, new Chebyshev());

        System.out.println("Chebyshev");
        System.out.println(res);

        assertArrayEquals(expected.toArray(), res.toArray());
    }
}
