// public class ArrOfStr {
//     public static void main(String[] args) {
//         // String s = "Manoj Kumar";
//         // String[] str = s.split(" ");
//         // for(String str1:str)
//         //     System.out.println(str1);

//         String str = "Manoj1 Kumar2 From3 BIT4";
//         String[] s = str.split(" ");
//         int i;
//         for(String elem : s){
//             i = (int)(elem.charAt(elem.length() - 1)-48);
//             System.out.println(i);
//         }
        
//     }
// }

//1859 - Sorting the Sentence
class ArrOfStr{
    public static String sortSentence(String str1) {
        String[] str = str1.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length;i++){
            String s = str[i];
            int len = s.length();
            int idx = (int)(s.charAt(len-1)-48);
            while(!(idx==i+1)){
                String temp = str[i];
                str[i] = str[idx-1];
                str[idx-1] = temp;
                idx =  (str[i].charAt(str[i].length() - 1) - 48);
            }
            s=str[i];
            str[i]=s.substring(0,s.length()-1);
        }
        int i=0;
        for(i=0;i<str.length-1;i++){
            sb.append(str[i]).append(" ");
        }
        sb.append(str[i]);
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "Kumar2 Manoj1 Karur6 from5 he3 is4 B.E8 degree9 pursuing7";
        String s1 = "World2 Hello1";
        System.out.println(sortSentence(s)+"\n"+sortSentence(s1));
    }
}