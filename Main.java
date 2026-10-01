public class Main {
    public static void main(String[] args) {

        MatrixOperations matrix = new MatrixOperations(3, 5, 10);

        System.out.println("Початкова матриця:");
        matrix.generateMatrix();
        matrix.printMatrix();

        System.out.println("\n1. Віднімання середнього арифметичного кожного рядка:");
        matrix.subtractRowAverage();
        matrix.printMatrix();

        System.out.println("\n2. Циклічний зсув:");
        matrix.shiftMatrix(1, 2);
        matrix.printMatrix();

        System.out.println("\n3. Видалення рядків і стовпців з максимальними елементами:");
        matrix.maxValueOfMatrix();
        matrix.deleteMaxRowsAndColumns();
        matrix.printMatrix();

        System.out.println("\n4. Поворот матриці на 90° за годинниковою стрілкою:");
        matrix.rotate90Clockwise();
        matrix.printMatrix();
    }
}
