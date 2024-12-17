import java.util.*;

public class SievePrimeMethod {
    static int prime_ctr=0;
    private static void sieveMethod(boolean[] prime,int n){
        for(int p=2;p*p<=n;p++){
            if(prime[p])
            {
                for(int i=p*p;i<=n;i+=p){
                    prime[i]=false;
                }
            }
        }
    }
    public static void main(String[] args) {
        int n;
        // Scanner sc = new Scanner(System.in);
        // n = sc.nextInt();
        n=100000000;
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        long startTime = System.currentTimeMillis();
        sieveMethod(prime, n);
        long endTime = System.currentTimeMillis();
        for(int i=2;i<=n;i++){
            if(prime[i]){
                prime_ctr++;
                // System.out.print(i+" ");
            }
        }
        System.out.print("\n"+prime_ctr+" ");
        long elapsedTime = endTime - startTime;
        System.out.println("\nTime taken: " + elapsedTime + " milliseconds");
    }
}


//sieveMethod Visualization 
// 1	11	21	31	41	51	61	71	81	91
// 2	12	22	32	42	52	62	72	82	92
// 3	13	23	33	43	53	63	73	83	93
// 4	14	24	34	44	54	64	74	84	94
// 5	15	25	35	45	55	65	75	85	95
// 6	16	26	36	46	56	66	76	86	96
// 7	17	27	37	47	57	67	77	87	97
// 8	18	28	38	48	58	68	78	88	98
// 9	19	29	39	49	59	69	79	89	99
// 10	20	30	40	50	60	70	80	90	100
