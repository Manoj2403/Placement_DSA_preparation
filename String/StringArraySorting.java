public class StringArraySorting {
    //Ascending Order
    // public static int compare(String str1,String str2){
    //     int i=0,j=0;
    //     int idx=0;
    //     while(i<str1.length() && j<str2.length()){
    //         if(str1.charAt(i)<str2.charAt(j)){
    //             return 1;
    //             // break;
    //         }
    //         else if(str2.charAt(j)<str1.charAt(i)){
    //             return 2;
    //             // break;
    //         }
    //         i++;
    //         j++;
    //         if(i==str1.length() && j==str2.length())
    //             return 0;
    //         else if(i==str1.length())
    //             return 1;
    //         else if(j==str2.length())
    //             return 2;
    //     }
            
    //     return idx;
    // }
    // public static void main(String[] args) {
    //     String[] arr = {"Manoj","Kumar","Vijay","Vetri","Sivan","Google"};
    //     for(int i=0;i<arr.length;i++){
    //         int minIdx=i;
    //         for(int j=i;j<arr.length;j++){
    //             if(compare(arr[minIdx],arr[j])==2){
    //                 minIdx=j;
    //             }
    //         }
    //         String temp = arr[i];
    //         arr[i] = arr[minIdx];
    //         arr[minIdx] = temp;
    //     }
    //     for(String word:arr){
    //         System.out.println(word);
    //     }
    // }
    
    //Descending Order
    public static int compare(String str1,String str2){
        int i=0,j=0;
        int idx=0;
        while(i<str1.length() && j<str2.length()){
            if(str1.charAt(i)>str2.charAt(j)){
                return 1;
                // break;
            }
            else if(str2.charAt(j)>str1.charAt(i)){
                return 2;
                // break;
            }
            i++;
            j++;
            if(i==str1.length() && j==str2.length())
                return 0;
            else if(i==str1.length())
                return 2;
            else if(j==str2.length())
                return 1;
        }
            
        return idx;
    }
    public static void main(String[] args) {
        String[] arr = {"aarthi","aathi","abi"};
        for(int i=0;i<arr.length;i++){
            int maxIdx=i;
            for(int j=i;j<arr.length;j++){
                if(compare(arr[maxIdx],arr[j])==2){
                    maxIdx=j;
                }
            }
            String temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
        for(String word:arr){
            System.out.println(word);
        }
        
    }
}