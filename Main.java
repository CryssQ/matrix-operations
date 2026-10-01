public class Main {

    public static void main(String[] args) {

        MatrixOperations matrix = new MatrixOperations();
        double[][] m = matrix.generateMatrix(3, 5, 10);

        System.out.println("Початкова матриця:");
        matrix.printDoubleMatrix(m);

        System.out.println("\n1. Віднімання середнього арифметичного кожного рядка:");
        m = matrix.subtractRowAverage(m);
        matrix.printDoubleMatrix(m);

        System.out.println("\n2. Циклічний зсув:");
        matrix.shiftMatrix(m, 1, 2);
        matrix.printDoubleMatrix(m);

        System.out.println("\n3. Видалення рядків і стовпців з максимальними елементами:");
        double maxValue = matrix.maxValueOfMatrix(m);
        System.out.println("Максимальне значення: " + maxValue);

        m = matrix.deleteMaxRowsAndColumns(m);
        matrix.printDoubleMatrix(m);

        System.out.println("\n4. Поворот матриці на 90° за годинниковою стрілкою:");
        m = matrix.rotate90Clockwise(m);
        matrix.printDoubleMatrix(m);
    }
}
