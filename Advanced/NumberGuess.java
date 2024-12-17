import java.util.*;
import java.math.*;
public class NumberGuess {
    static Scanner sc = new Scanner(System.in);
    public static boolean isValidDigit(int num){
            return num>=1 && num<=100;
    }
    public static String getName(){
        // Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name:");
        return sc.nextLine().toUpperCase();
    }
    public static void displayArray(int[] attemptArray,int counter){
        for(int i=0;i<=counter;i++){
            System.out.print(attemptArray[i]+" ");
        }
        System.out.println();
    }
    public static void playGame(){
        String userName = getName();
        int randNum = (int)(Math.random()*101);
        int[] attemptArray = new int[100];
        int index=0;
        if(!isValidDigit(randNum))
            return;
        int counter=0;
        System.out.println("The Number is Generated , Now your Turn to find out this Number...");
        System.out.println(userName+" please,Enter the Number from 1 to 100:");
        while(true){    
            int userNum = sc.nextInt();
            sc.nextLine()
;            attemptArray[index++] = userNum;
            int diff = randNum-userNum;
            if(isValidDigit(userNum) && randNum==userNum)
            {
                System.out.println(userName +" you won the game....");
                break;
            }
            else if(isValidDigit(userNum) && diff>=0 && diff<=10)
                System.out.println(userName + " your Number is Low..kindly increase it");
            else if(isValidDigit(userNum) && diff>10 && diff<=99)
                System.out.println(userName + " your Number is Too Low..kindly increase it");
            else if(isValidDigit(userNum) && diff<=0 && diff>=-10)
                System.out.println(userName + " your Number is High..kindly reduce it");
            else if(isValidDigit(userNum) && diff<-10 && diff>=-99)
                System.out.println(userName + " your Number is Too High..kindly reduce it");
            else
                System.out.println(userName+" Enter the Valid Number");
            counter++;
        }
        System.out.println("Your Attempts:"+counter);
        if(counter<=5)
            System.out.println("Congrats! "+userName + " You Played Excellent\nGold Medal is for you");
        else if(counter>5 && counter<=10)
            System.out.println("Congrats! "+userName + " You Played Very Good\nSilver Medal is for you");
        else if(counter>10 && counter<=15)
            System.out.println("Congrats! "+userName + " You Played Good\nBronze Medal is for you"); 
        else
            System.out.println("Congrats! "+userName + " You Played well....\nTry to come under 15 ");
        System.out.println("Do you Need to see the Attempts what you have tried?");
        String str = sc.nextLine().toLowerCase();
        if(str.equals("yes"))
            displayArray(attemptArray,counter);
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Type \"START\" to Play the Game:");
        while(true){
            System.out.println("Type \"START\" or \" EXIT\"");
            String str = sc.nextLine().toLowerCase();
            if(str.equals("start")){
                playGame();
            }
            else if(str.equals("exit"))
                break;
        }
        sc.close();
    }
}
