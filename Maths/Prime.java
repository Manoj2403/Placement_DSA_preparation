import java.util.*;
public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum=0;
        int i=0;
        for(i=2;i<num/2;i++){
            if(num%i==0){
                System.out.println(i);
                System.out.println("Not a Prime");
                return;
            }
        }
        
        System.out.println("Prime");
        
    }
}


//Addition of Prime Numbers

// import java.util.*;

// public class Prime {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
        
//         System.out.print("Enter the starting range: ");
//         int start = sc.nextInt();
        
//         System.out.print("Enter the ending range: ");
//         int end = sc.nextInt();
        
//         int sum = 0;
        
//         for (int num = start; num <= end; num++) {
//             if (isPrime(num)) {
//                 sum += num;
//             }
//         }
        
//         System.out.println("Sum of prime numbers between " + start + " and " + end + " is: " + sum);
//     }

//     // Function to check if a number is prime
//     private static boolean isPrime(int num) {
//         if (num <= 1) {
//             return false;
//         }
        
//         for (int i = 2; i <= Math.sqrt(num); i++) {
//             if (num % i == 0) {
//                 return false;
//             }
//         }
        
//         return true;
//     }
// }
