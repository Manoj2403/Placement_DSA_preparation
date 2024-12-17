import java.util.*;
public class DateCalculate {
    public static void print(String input){
        // String input = "6-7-11-18-22-26";
        String[] strArr = input.split("-");
        int[] arr = new int[strArr.length];
        int k = 0;
        for (String str : strArr) {
            arr[k++] = Integer.parseInt(str);
        }
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        if ((arr[0]-1)>=5) {
            sb.append("X-");
        }
        for (int i = 0; i < n - 1; i++) {
            int val1 = arr[i];
            int val2 = arr[i + 1];
            sb.append(val1 + "-");
            if ((val2 - val1) >= 5 && i != 0) {
                sb.append("X-");
            }
        }
        sb.append(arr[n - 1]);
        if ((31 - arr[n - 1]) >= 5) {
            sb.append("-X");
        }
        System.out.println(new String(sb));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String in format y-y-y : ");
        String input = sc.nextLine();
        System.out.print("Enter No of days to Reserved : ");
        int n = sc.nextInt();
        print(input);
    }
}