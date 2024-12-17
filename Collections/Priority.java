// package Collections;
import java.util.*;
public class Priority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int val,count=0;
        int cur_sum;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i=0;i<size;i++){
            val = sc.nextInt();
            pq.add(val);
        }
        while(pq.size()>1){
            cur_sum = pq.poll()+pq.poll();
            count+=cur_sum;
            // System.out.println(count);
            pq.add(cur_sum);
        
        }
        System.out.println(count);
        sc.close();
    }
}