class Square_it {
    private int digit, sum = 0;

    public int square(int num) {
        while (true) {
            if (num != 0) {
                digit = num % 10;
                sum = sum + digit * digit;
                num /= 10;
            } else {
                break;
            }
        }
        return sum;
    }
}

public class Solution {
    public boolean isHappy(int n) {
        Square_it square_it = new Square_it();
        int squared_num = square_it.square(n);
        while (squared_num != 1) {
            if (squared_num != n) {
                squared_num = square_it.square(squared_num);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19)); // Output: true
    }
}
