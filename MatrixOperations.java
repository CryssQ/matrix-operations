import java.util.Random;

public class MatrixOperations {
    private int[][] matrix;
    private int maxNum;
    private int row;
    private int column;
    private double avrg;

    public MatrixOperations(int row, int column, int maxNum) {
        matrix = new int[row][column];
        this.maxNum = maxNum;
        this.row = row;
        this.column = column;
    }

public void generateMatrix() {
    Random r = new Random();

    System.out.print("\t\t");
    for (int j = 0; j < matrix[0].length; j++) {
        System.out.print("стовпець " + (j + 1) + "\t");
    }
    System.out.println();

    for (int i = 0; i < matrix.length; i++) {
        System.out.print("рядок " + (i + 1) + "\t\t");

        for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = r.nextInt(this.maxNum) + 1;
            System.out.print(matrix[i][j] + "\t\t");
        }

        System.out.println();
    }
}

public void averageMatrix(){

    int sum = 0;
    int count = this.row * this.column;

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            sum += matrix[i][j];
        }
    }
    avrg = (1.0*sum)/count;
}

public void SubtractionMatrix(){
    
}


}

