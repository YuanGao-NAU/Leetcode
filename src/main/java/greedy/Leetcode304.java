package greedy;

public class Leetcode304 {

    int[][] prefixSum;

    public Leetcode304(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefixSum = new int[rows][cols];

        int sum = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                sum = sum + matrix[i][j];
                prefixSum[i][j] = (i != 0 ? prefixSum[i-1][j] : 0) + sum;
            }
            sum = 0;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = prefixSum[row2][col2];
        if(row1 > 0) {
            res -= prefixSum[row1-1][col2];
        }
        if(col1 > 0) {
            res -= prefixSum[row2][col1-1];
        }
        if(row1 > 0 && col1 > 0) {
            res += prefixSum[row1-1][col1-1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        Leetcode304 leetcode304 = new Leetcode304(matrix);
        System.out.println(leetcode304.sumRegion(2,1,4,3));
//        System.out.println(leetcode304.sumRegion(1,1,2,2));
//        System.out.println(leetcode304.sumRegion(1,2,2,4));

//        int[][] matrix = {
//                {1},
//                {-7}
//        };
//        Leetcode304 leetcode304 = new Leetcode304(matrix);
//        System.out.println(leetcode304.sumRegion(0,0,0,0));
//        System.out.println(leetcode304.sumRegion(1,0,1,0));
//        System.out.println(leetcode304.sumRegion(0,0,1,0));

    }
}
