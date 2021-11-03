package data.structures;


import java.util.ArrayList;
import java.util.List;

/**
 * @author szhang
 *
 * Sparse Array:
 * 1. N by 3 array
 * 2. array[0] contains origin_array information
     * a. array[0][0] is the row of origin_array
     * b. array[0][1] is the col of origin_array
     * c. array[0][2] is the total non-zero elements of origin_array
 * 3. array[i] represents a non-zero element
     * a. array[i][0]: position_x
     * b. array[i][1]: position_y
     * c. array[i][2]: value
 */
public class SparseArray {

    public static int[][] write(int[][] input) {
        int row = input.length;
        int col = input[0].length;
        int total = 0;
        List<List<Integer>> outputList = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (input[i][j] != 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    temp.add(input[i][j]);
                    outputList.add(temp);
                    total++;
                }
            }
        }

        List<Integer> row0 = new ArrayList<>();
        row0.add(row);
        row0.add(col);
        row0.add(total);
        outputList.add(0, row0);

        int[][] outputArray = outputList.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
        return outputArray;
    }

    public static int[][] read(int[][] input) {
        int row = input[0][0];
        int col = input[0][1];
        int total = input[0][2];
        int[][] output = new int[row][col];

        for (int i = 1; i <= total; i++) {
            int m = input[i][0];
            int n = input[i][1];
            int value = input[i][2];
            output[m][n] = value;
        }

        return output;
    }

    public static void print(int[][] input) {
        int row = input.length;
        int col = input[0].length;

        System.out.println("===========  start ==========");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(input[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("===========  end ==========");

    }

    public static void main(String[] args) {
        int[][] input = new int[10][10];

        input[0][0] = 19;
        input[1][1] = 22;
        input[1][2] = 33;

        int[][] writeRes = write(input);
        int[][] readRes = read(writeRes);

        print(input);
        print(writeRes);
        print(readRes);
    }
}
