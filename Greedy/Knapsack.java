import java.util.*;

class Obj{
    int val;
    int wt;
    double pwratio;
}
public class Knapsack {
    static Obj[] getObj(int[] values,int[] weights){
        Obj[] obj = new Obj[values.length];
        for(int i=0;i<values.length;i++){
            obj[i] = new Obj();
            obj[i].val=values[i];
            obj[i].wt=weights[i];
        }
        return obj;
    }
    static void computePWRatio(Obj[] obj){
        int n = obj.length;
        for(int i=0;i<n;i++){
            obj[i].pwratio = (1.0 * obj[i].val) / obj[i].wt;
        }
    }
    static void sort(Obj[] obj){
        for(int i=0;i<obj.length;i++){
            boolean flag = false;
            for(int j=0;j<obj.length-i-1;j++){
                if(obj[j].pwratio<obj[j+1].pwratio){
                    Obj temp = obj[j];
                    obj[j] = obj[j+1];
                    obj[j+1] = temp;
                    flag=true;
                }
                
            }
            if(!flag)
                    break;
        }
    }
    static double fractionalKnapsack(int[] values, int[] weights, int W) {
        Obj[] obj = getObj(values,weights);
        computePWRatio(obj);
        sort(obj);
        // Arrays.sort(obj, (a, b) -> Double.compare(b.pwratio, a.pwratio));
        
        double maxProfit = 0.0;
        int i=0;
        for(i=0;i<obj.length;i++){
            if(obj[i].wt<=W){
                W-=obj[i].wt;
                maxProfit+=obj[i].val;
            }
            else
                break;
        }
        if(i<obj.length && W>0){
            maxProfit = maxProfit + (1.0*(W*obj[i].pwratio));
        }
        return maxProfit;
        
    }

    public static void main(String[] args) {
        int[] values = new int[]{25,24,15};
        int[] weights = new int[]{18,15,10};

        double maxProfit = fractionalKnapsack(values,weights,20);
        System.out.println("The Maximum Profit is : " + maxProfit);
    }
}