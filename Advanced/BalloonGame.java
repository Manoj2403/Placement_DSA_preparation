import java.util.*;

public class BalloonGame {

    private static int m = 5;
    private static int n = 5;

    private static Set<Character> colourSet = new HashSet<>(Arrays.asList('r', 'g', 'b'));

    public static boolean fallBalloon(char[][] mat, int row, int[] height) {

        if (row < 0 || row >= m) {
            return false;
        }

        for (int col = 0; col < n; col++) {

            for (int i = row; i > 0; i--) {

                mat[i][col] = '\u0000';

                if (mat[i - 1][col] == ' ' || mat[i - 1][col] == '\u0000') {
                    break;
                }

                mat[i][col] = mat[i - 1][col];
                mat[i - 1][col] = '\u0000';
            }

            height[col]++;
        }

        return true;
    }

    public static void emptyMatrix(char[][] mat, int[] height) {

        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i], '\u0000');
        }

        Arrays.fill(height, m);
    }

    public static boolean fillCell(char[][] mat, int[] height, int col, char balloonColour) {

        if (col < 0 || col >= n)
            return false;

        int row = height[col] - 1;

        if (row < 0 || row >= m)
            return false;

        mat[row][col] = balloonColour;
        height[col]--;

        return true;
    }

    public static boolean isMatch(char[][] mat, int row) {

        if (row < 0 || row >= m)
            return false;

        for (int col = 1; col < n; col++) {
            if (mat[row][col] != mat[row][col - 1])
                return false;
        }

        return true;
    }

    public static void printMatrix(char[][] mat) {

        System.out.println("===============");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char display = (mat[i][j] == '\u0000') ? '.' : mat[i][j];
                System.out.print(display + "  ");
            }
            System.out.println();
        }

        System.out.println("===============");
    }

    public static boolean checkMatrixSpace(int[] height) {

        for (int i = 0; i < height.length; i++) {
            if (height[i] != 0)
                return true;
        }

        return false;
    }

    public static boolean isChar(char c) {
        return (c >= 'a' && c <= 'z');
    }

    public static boolean isCorrectColour(char balloonColour) {
        return colourSet.contains(balloonColour);
    }

    public static char toLowerCase(char balloonColour) {
        if (balloonColour >= 'a' && balloonColour <= 'z')
            return balloonColour;
        return (char) (balloonColour + 32);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] mat = new char[m][n];
        int[] height = new int[mat[0].length];

        Arrays.fill(height, n);

        System.out.println("*********** Balloon Game *********** ");
        try{
            while (true) {

            System.out.println("Enter the Column number to fill balloon ("+0+" - "+(n-1)+"):");
            int col = sc.nextInt();

            System.out.println("Enter the Balloon Colour (R-red / G-green / B-blue):");
            char balloonColour = sc.next().charAt(0);

            balloonColour = toLowerCase(balloonColour);

            if (!isChar(balloonColour)) {
                System.out.println("Enter Character Only.");
                continue;
            }

            if (!isCorrectColour(balloonColour)) {
                System.out.println("Enter Available Balloon Colour only.");
                continue;
            }

            if (fillCell(mat, height, col, balloonColour)) {

                int row = height[col];

                if (isMatch(mat, row)) {

                    System.out.println(balloonColour + " colour is Matched.");

                    if (fallBalloon(mat, row, height)) {
                        System.out.println("Balloon has Fallen.");
                    } else {
                        System.out.println("Balloon has not Fallen.");
                    }

                } else {

                    if (!checkMatrixSpace(height)) {

                        System.out.println("****Space is Filled in the Matrix****");
                        printMatrix(mat);
                        emptyMatrix(mat, height);

                    }

                    System.out.println("Colour is Not Matched");
                }

            } else {

                System.out.println("Matrix is Not filled with this " + balloonColour);
            }

            printMatrix(mat);
        }
        }
        catch(Exception e){
            throw new InputMismatchException("Input is Mismatched here");
        }

        
    }
}