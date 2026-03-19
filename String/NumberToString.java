import java.util.*;

public class NumberToString {
    public static String convertNumberToString(int n) {
        if (n == 0) {
            return "Zero";
        }
        String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
        String[] elevenSeries = { "", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen" };
        String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

        String str = "";
        int thousand = 0;
        // If it is thousand we need to change to less than 1000 and handle thousand
        // case separately
        if (n >= 1000) {
            thousand = n / 1000;
            n %= 1000;
        }

        // if thousand range number is available
        if (thousand > 0) {
            // if thousand range number is above or equals to twenty
            if ((thousand == 10) || (thousand >= 20 && thousand < 100)) {
                int idx = thousand / 10;
                str = str + tens[idx] +" ";
                thousand %= 10;
            }
            // if thousand range number is between 11-20
            if (thousand >= 11 && thousand < 20) {
                int idx = thousand % 10;
                str = str + elevenSeries[idx] +" ";
            }
            // if thousand range number is single digit
            if (thousand !=0 && thousand < 10) {
                int idx = thousand;
                str = str + ones[idx] + " ";
            }
            str = str + "Thousand ";
        }
        if (n == 0) {
            str = str.trim();
        }

        // if number is above hundred
        if (n >= 100 && n < 1000) {
            int idx = n / 100;
            str = str + ones[idx] + " Hundred ";
            n %= 100;
        }
        // if number is betwen 11-20
        if (n >= 11 && n < 20) {
            int idx = n % 10;
            str = str + elevenSeries[idx] + " ";
            n = 0;
        }
        // if number is like tens series (Twenty,Thirty,.....)
        if ((n == 10) || (n >= 20 && n < 100)) {
            int idx = n / 10;
            str = str + tens[idx] + " ";
            n %= 10;
        }
        // if number is single digit
        if (n >= 1 && n < 10) {
            int idx = n;
            str = str + ones[idx];
            n /= 10;
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the Number to print in String format : (Any from 0-99999)");
            int n = sc.nextInt();
            if (n < 0 || n >= 100000) {
                System.out.println("Enter Number in Mentioned Range.");
                break;
            }
            String numberString = convertNumberToString(n);
            System.out.println(numberString);
            System.out.println("===========================================================");
        }
        sc.close();
    }
}
