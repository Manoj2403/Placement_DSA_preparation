import java.util.*;
public class Dup
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // sc.nextLine();
        while(true){
            String s = sc.next();
            if(s.equals("exit"))
                break;
        // String s1 = "abc";
            int dup=1;
            for(int i=0;i<s.length();i++){
                for(int j=i+1;j<s.length();j++){
                    if(s.charAt(i)==s.charAt(j))
                        ++dup;
                        break;
                }
            }
            int nd=s.length()-dup;
            if(nd==dup)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
        sc.close();
	}
}
