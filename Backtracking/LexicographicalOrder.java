import java.util.*;

public class LexicographicalOrder {
    public static void solve(int currNum,int n,List<Integer> res){
        if(currNum>n)
            return ;
        res.add(currNum);
        for(int i=0;i<=9;i++){
            int nextNum = currNum*10+i;
            if(nextNum>n)
                return ;
            solve(nextNum,n,res);
        }
    }
    public static void main(String[] args) {
        int n = 13;
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            solve(i,n,res);
        }
        System.out.println(res);
    }
}

/*
    1            2           3               4               5           6           7           8           9
|   |   |   |           
10  11  12  13          

 */