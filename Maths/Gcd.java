public class Gcd{
    public static int gcd(int a,int b){
        if(a==0)
            return b;
        return gcd(b%a,a);
    }
    public static void main(String[] args) {
        System.out.println((4*6)/gcd(4,6));
    }
}