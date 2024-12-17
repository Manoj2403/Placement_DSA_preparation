public class LetterPattern {
    public static void main(String[] args) {
		int ascii=64;
		int n=4;
		for(int i=1;i<=n;i++){
		    for(int j=1;j<=i;j++){
		        if(i%2==0){
		            if(j%2==1){
		                ascii+=33;
		            }
		            else{
		                ascii-=31;
		            }
		            System.out.print((char)ascii+" ");
		        }
		        else{
		            if(j==1)
		                ascii+=1;
		            else if(j%2==1)
		                ascii-=31;
		            else    
		                ascii+=33;
                    System.out.print((char)ascii+" ");
		        }
		    }
		    System.out.println();
		}
	}
}

/*
 * A
 * b C
 * D e F
 * g H i J
 * K l M n O
 * p Q r S t U 
 * W x Y z
 */
