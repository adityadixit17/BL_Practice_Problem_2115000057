import java.util.Random;

public class MatrixOperations {

    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] - mat2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat2[0].length;
        int common = mat2.length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < common; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = createRandomMatrix(3, 3);
        int[][] matrix2 = createRandomMatrix(3, 3);

        System.out.println("Matrix 1:");
        displayMatrix(matrix1);

        System.out.println("Matrix 2:");
        displayMatrix(matrix2);

        System.out.println("Addition:");
        displayMatrix(addMatrices(matrix1, matrix2));

        System.out.println("Subtraction:");
        displayMatrix(subtractMatrices(matrix1, matrix2));

        System.out.println("Multiplication:");
        displayMatrix(multiplyMatrices(matrix1, matrix2));

        System.out.println("Transpose of Matrix 1:");
        displayMatrix(transposeMatrix(matrix1));
    }
}
