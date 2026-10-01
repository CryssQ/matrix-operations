import java.util.Random;

public class MatrixOperations {

    private double[][] matrix;
    private int maxNum;
    private double maxValue;

    public double[][] generateMatrix(int row, int column, int maxNum) {
        if (row <= 0 || column <= 0 || maxNum <= 0) {
            throw new IllegalArgumentException("Row, column and maxNum must be greater than 0");
        }

        matrix = new double[row][column];
        this.maxNum = maxNum;

        Random random = new Random();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = random.nextInt(maxNum) + 1;
            }
        }
        return matrix;
    }

    public void printDoubleMatrix(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%.1f\t", m[i][j]);
            }
            System.out.println();
        }
    }

    public double[][] subtractRowAverage(double[][] m) {
        double[][] result = new double[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            double sum = 0;

            for (int j = 0; j < m[i].length; j++) {
                sum += m[i][j];
            }

            double average = sum / m[i].length;

            for (int j = 0; j < m[i].length; j++) {
                result[i][j] = m[i][j] - average;
            }
        }

        return result;
    }

    public void shiftMatrix(double[][] m, int up, int right) {
        int rows = m.length;
        int columns = m[0].length;

        up = ((up % rows) + rows) % rows;
        right = ((right % columns) + columns) % columns;

        for (int shift = 0; shift < up; shift++) {
            double[] firstRow = m[0];

            for (int i = 0; i < rows - 1; i++) {
                m[i] = m[i + 1];
            }
            m[rows - 1] = firstRow;
        }

        for (int shift = 0; shift < right; shift++) {
            for (int i = 0; i < rows; i++) {
                double last = m[i][columns - 1];
                    for (int j = columns - 1; j > 0; j--) {
                        m[i][j] = m[i][j - 1];
                    }
                m[i][0] = last;
            }
        }
    }

    public double maxValueOfMatrix(double[][] m) {
        maxValue = m[0][0];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] > maxValue) {
                    maxValue = m[i][j];
                }
            }
        }

        return maxValue;
    }

    public double[][] deleteMaxRowsAndColumns(double[][] m) {
        boolean[] rows = new boolean[m.length];
        boolean[] columns = new boolean[m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == maxValue) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        int newRows = 0;
        int newColumns = 0;

        for (boolean value : rows) {
            if (!value) {
                newRows++;
            }
        }

        for (boolean value : columns) {
            if (!value) {
                newColumns++;
            }
        }

        double[][] result = new double[newRows][newColumns];

        int r = 0;

        for (int i = 0; i < m.length; i++) {
            if (rows[i]) {
                continue;
            }

            int c = 0;

            for (int j = 0; j < m[i].length; j++) {
                if (columns[j]) {
                    continue;
                }

                result[r][c++] = m[i][j];
            }
            r++;
        }

        return result;
    }

    public double[][] rotate90Clockwise(double[][] m) {
        int rows = m.length;
        int columns = m[0].length;

        double[][] result = new double[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][rows - 1 - i] = m[i][j];
            }
        }

        return result;
    }
}
