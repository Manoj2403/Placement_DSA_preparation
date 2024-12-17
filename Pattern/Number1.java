public class Number1 {
    public static void main(String[] args) {
        int n=5;
        int temp=1;
        for(int i=1;i<=n;i++){
            int val = i+temp-1;
            for(int j=1;j<=i;j++){
                if(i%2==0){
                    System.out.print(val+" ");
                    val--;
                }
                else{
                    System.out.print(temp+" ");
                }
                temp++;
            }
            System.out.println();
        }
    }
}