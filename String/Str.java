// package String;

public class Str {
    public static void main(String[] args) {
        // String s = new String("Manoj");
        // String s1 = new String("Manoj");
        // //Both are new objects and stored in Heap area

        // String s2 = "Manoj";
        // String s3 = "Manoj";
        // //Both are referring to same object in SCP(String Constant Pool)
        // // s=s.concat("Kumar");
        // System.out.println(s==s1);
        // System.out.println(s2==s3);
        //-------------------------------------------------------------------------->
        String s = "Manoj   Kumar V";
        int left=0;
        int right=s.length()-1;
        String temp="";
        String ans="";
        // while(left<=right){
        //     char ch = s.charAt(left);
        //     if(ch!=' '){
        //         temp+=ch;
        //     }
        //     else{
        //         ans=temp+""+ans;
        //         temp="";
        //     }
        //     left++;
        // }
        while (left <= right)
	{
		char ch = s.charAt(left);
		if (ch != ' ')
		{
			temp += ch;
		}
		else if (ch == ' ')
		{
			if (!ans.equals(""))
			{
				ans = temp + " " + ans;
			}
			else
			{
				ans = temp;
			}
			temp = "";
		}
		left++;
	}
    if (!temp.equals(""))
	{
		if (!ans.equals(""))
		{
			ans = temp + " " + ans;
		}
		else
		{
			ans = temp;
		}
	}
        System.out.println(ans);
        //-------------------------------------------------------------------------->
        // String ch = " ";
        // System.out.println(ch.equals(" "));
    }
}
