
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class FlamesCalc {
    public static int findWinner(int n,int k){
        if(n==1)
            return 1;
        return (findWinner(n-1,k)+k-1)%n+1;
    }
    public static String getFlames(String str, String str2) {
        int totalLen = removeCommon(str, str2);
        if(totalLen==0){
            return "Invalid";
        }
        String flames = "FLAMES";
        StringBuilder flamesBuilder = new StringBuilder(flames);
        // int index = 0;
        // while (flamesBuilder.length() > 1) {
        //     index = (index + totalLen - 1) % flamesBuilder.length();
        //     flamesBuilder.deleteCharAt(index);
        // }
        char resChar = flamesBuilder.charAt(findWinner(flamesBuilder.length(),totalLen));
        switch (resChar) {
            case 'F':
                return "Friends";
            case 'L':
                return "Love";
            case 'A':
                return "Affection";
            case 'M':
                return "Marriage";
            case 'E':
                return "Enemy";
            case 'S':
                return "Sister";
            default:
                return "Invalid";
        }
    }

    public static int removeCommon(String str1, String str2) {
        str1 = str1.replaceAll("\\s","").toLowerCase();
        str2 = str2.replaceAll("\\s","").toLowerCase();
        // System.out.println("After removing spaces from " + str1 + " and " + str2);
        char[] name1 = str1.toCharArray();
        char[] name2 = str2.toCharArray();
        Arrays.sort(name1);
        // System.out.println(name1);
        Arrays.sort(name2);
        // System.out.println(name2);
        int i = 0, j = 0;
        int count = 0;
        while (i != name1.length && j != name2.length) {
            if (name1[i] == name2[j]) {
                count++;
                i++;
                j++;
            } else if ((int) name1[i] > (int) name2[j])
                j++;
            else
                i++;
        }
        int totalLen = (name1.length + name2.length) - (2 * count);
        return totalLen;
        //--------------------------------Alternate Idea--------------------------
        // for(int i=0;i<str1.length();i++){
        //     char c = str1.charAt(i);
        //     if(c==' ')continue;
        //     else{
        //         int idx = (int)(c-97);
        //         hash[idx]++;
        //     }
        // }
        // for(int i=0;i<str2.length();i++){
        //     char c = str2.charAt(i);
        //     if(c==' ')continue;
        //     else{
        //         int idx = (int)(c-97);
        //         hash[idx]--;
        //     }
        // }
        // int total=0;
        // for(int i=0;i<26;i++){
        //     total += (hash[i]<0?-1*hash[i]:hash[i]);
        // }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter two names to find the relation between them:");
            String str1 = sc.nextLine();
            if(str1.equals("exit")){
                break;
                // return;
            }
            String str2 = sc.nextLine();
            // System.out.println("After removing common characters between " + str1.toUpperCase() +" and " +str2.toUpperCase() + " is "+removeCommon(str1.toLowerCase(),str2.toLowerCase()));
            System.out.println("The relation between " + str1.toUpperCase() +" and " +str2.toUpperCase() + " is "+getFlames(str1.toLowerCase(),str2.toLowerCase()));
            System.out.println("--------------------------------------------------------------");
        }
        sc.close();
    }
}