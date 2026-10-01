import java.util.Random;

public class MatrixOperations {

    private double[][] matrix;
    private int maxNum;
    private double maxValue;

    public MatrixOperations(int row, int column, int maxNum) {
        matrix = new double[row][column];

        this.maxNum = maxNum;
    }

    public double[][] generateMatrix() {
        Random random = new Random();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = random.nextInt(maxNum) + 1;
            }
        }
    }

    public void printDoubleMatrix(double[][] m) {
         int row = m.length;
        int column = m[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("%f.2\t", m[i][j]);
            }
            System.out.println();
        }
    }

    public double[][] subtractRowAverage(int[][] m) {
        int row = m.length;
        int column = m[0].length;
         double[][] result = new double[m.length][m[0].length];
        for (int i = 0; i < row; i++) {
            double sum = 0;

            for (int j = 0; j < column; j++) {
                sum += matrix[i][j];
            }

            double average = sum / column;

            for (int j = 0; j < column; j++) {
                matrix[i][j] -= average;
            }
        }
        return result;
    }

    public void shiftMatrix(int up, int right) {
        up %= row;
        right %= column;

        for (int shift = 0; shift < up; shift++) {
            double[] firstRow = matrix[0];

            for (int i = 0; i < row - 1; i++) {
                matrix[i] = matrix[i + 1];
            }

            matrix[row - 1] = firstRow;
        }

        for (int shift = 0; shift < right; shift++) {
            for (int i = 0; i < row; i++) {
                double last = matrix[i][column - 1];

                for (int j = column - 1; j > 0; j--) {
                    matrix[i][j] = matrix[i][j - 1];
                }

                matrix[i][0] = last;
            }
        }
    }

    public void maxValueOfMatrix() {
        maxValue = matrix[0][0];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                }
            }
        }

        System.out.println("Max value: " + maxValue);
    }

    public double[][] deleteMaxRowsAndColumns(double[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == maxValue) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        int newRow = 0;
        int newColumn = 0;

        for (boolean value : rows) {
            if (!value)
                newRow++;
        }

        for (boolean value : columns) {
            if (!value)
                newColumn++;
        }

        double[][] result = new double[newRow][newColumn];

        int r = 0;

        for (int i = 0; i < row; i++) {
            if (rows[i])
                continue;

            int c = 0;

            for (int j = 0; j < column; j++) {
                if (columns[j])
                    continue;

                result[r][c++] = matrix[i][j];
            }

            r++;
        }

        return result;
    }

    public void rotate90Clockwise() {
        if (row != column) {
            return;
        }

        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < column; j++) {
                double temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column / 2; j++) {
                double temp = matrix[i][j];
                matrix[i][j] = matrix[i][column - 1 - j];
                matrix[i][column - 1 - j] = temp;
            }
        }
    }
}
