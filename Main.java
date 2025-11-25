//find top 3 elements in sentence
import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr=s.split(" ");
        Map<String,Integer> hm=new HashMap<>();
        for(String i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>(
            (a,b)->b.getValue()-a.getValue()
        );
        pq.addAll(hm.entrySet());
        System.out.println("Top 3 frequent words");
        int count=0;
        while(!pq.isEmpty() && count<2){
            Map.Entry<String,Integer> entry=pq.poll();
            System.out.println(entry.getKey()+":"+entry.getValue());
            count++;
        }

        
    }

}